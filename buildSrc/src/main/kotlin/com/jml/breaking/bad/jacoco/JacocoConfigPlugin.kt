package com.jml.breaking.bad.jacoco


import com.android.build.gradle.*
import com.android.build.gradle.api.BaseVariant
import org.gradle.api.DomainObjectSet
import  com.jml.breaking.bad.ext.debug
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.Task
import org.gradle.api.internal.project.ProjectInternal
import org.gradle.api.logging.Logger
import org.gradle.api.tasks.TaskCollection
import org.gradle.api.tasks.TaskContainer
import org.gradle.api.tasks.testing.Test
import org.gradle.testing.jacoco.plugins.JacocoTaskExtension
import org.gradle.testing.jacoco.tasks.JacocoReport


/**
 * Jacoco Plugin
 *
 * How to use id:
 *
 *    apply plugin: "com.jacoco-plugin"
 * Example config:
 *
 *  jacocoPlugin{
 *       options{
 *           isEnabled = false
 *           excludes = [ "*R.class", R\$*.class",/BuildConfig.*" ... ]
 *       }
 *   }
 *
 *  Important: param coverage will activate UI coverage
 *
 *  ./gradlew -Pcoverage clean connectedDebugAndroidTest
 */


open class JacocoConfigPlugin : Plugin<ProjectInternal> {
    lateinit var logger: Logger

    override fun apply(project: ProjectInternal) {
        logger = project.logger

        project.extensions.create("jacocoPlugin", JacocoExtension::class.java)

        project.configureJacoco()
    }

    private fun Project.configureJacoco() {
        afterEvaluate {
            extensions.getByType(JacocoExtension::class.java)
                .run {
                    val jacocoOptions = this.options

                    if (jacocoOptions.isEnabled) {
                        project.plugins.apply("jacoco")
                        /*
                          project.tasks.withType(Test::class.java) {test->


                               test.configure(JacocoTaskExtension::class.java) {
                              it.isIncludeNoLocationClasses = jacocoOptions.includeLocationClasses
                             }
                          }

                          */



                        project.plugins.all {
                            when (it) {
                                   is LibraryPlugin -> {
                                       project.extensions.getByType(LibraryExtension::class.java).run {
                                           configureJacocoByVariants(project, libraryVariants, jacocoOptions)
                                       }
                                   }
                                   is AppPlugin -> {
                                       project.extensions.getByType(AppExtension::class.java).run {
                                           configureJacocoByVariants(project, applicationVariants, jacocoOptions)
                                       }
                                   }


                            }
                        }

                        // todo apply this param when we want to execute the full coverage ./gradlew -Pcoverage clean connectedDebugAndroidTest
                        project.extensions.getByType(BaseExtension::class.java).buildTypes.debug {
                            isTestCoverageEnabled = project.hasProperty("coverage")
                        }
                    }
                }
        }
    }

    private fun TaskContainer.findOrCreateJacocoTestReportTask(): Task {
        return findByName("jacocoTestReport")
            ?: create("jacocoTestReport")
                .apply {
                    group = "Reporting"
                }
    }

    private fun configureJacocoByVariants(
        project: Project,
        variants: DomainObjectSet<out BaseVariant>,
        options: JacocoOptions
    ) {
        val jacocoTestReportTask = project.tasks.findOrCreateJacocoTestReportTask()

        variants.all { variant ->
            //  val isDebuggable = this.buildType.isDebuggable
            //  if (!isDebuggable) {
            //      logger.info("Skipping Jacoco for $name because it is not debuggable.")
            //      return@all
            //  }
            val reportTask = createReportTask(project, variant, options)

            jacocoTestReportTask.dependsOn(reportTask)

            logTaskAdded(reportTask)
        }
    }

    private fun createReportTask(
        project: Project,
        variant: BaseVariant,
        options: JacocoOptions
    ): JacocoReport {
        val variantName = variant.name
        val testTask = testTask(project.tasks, variant)


        return project.tasks
            .create("jacoco${variant.name.capitalize()}Report",JacocoReport::class.java) { newTask ->
                  newTask.group = "Reporting"
                  newTask.description = "Generate Jacoco coverage reports for the ${project.name}"
                  newTask.dependsOn(testTask)
                  val buildDir = project.buildDir
                  val javaClasses = project
                      .fileTree("$buildDir/intermediates/javac/${variant.name.capitalize()}") {
                          it.setExcludes(options.excludes)
                      }
                  val kotlinClasses = project
                      .fileTree("$buildDir/tmp/kotlin-classes/$variantName") {
                          it.setExcludes(options.excludes)
                      }
                  val classDirectoriesTree = project.files(javaClasses, kotlinClasses)
                  val sourceDirectoriesTree = project.fileTree("${project.projectDir}") {
                      it.include("src/main")
                  }
                  val executionDataTree = project.fileTree(project.buildDir) {
                      it.include("**/**/*.exec", "**/**/*.ec")
                  }

                  newTask.executionData.setFrom(executionDataTree)
                  newTask.classDirectories.setFrom(classDirectoriesTree)
                  newTask.sourceDirectories.setFrom(sourceDirectoriesTree)
                  newTask.additionalSourceDirs.setFrom(sourceDirectoriesTree)

                  newTask.reports {
                      it.xml.isEnabled = true
                      it.html.isEnabled = true
                      it.csv.isEnabled = false
                  }


            }
    }

    private fun testTask(tasks: TaskCollection<Task>, variant: BaseVariant) =
        tasks.getByName("test${variant.name.capitalize()}UnitTest")

    private fun logTaskAdded(reportTask: JacocoReport) {
        logger.info("Added $reportTask")
        logger.info("  executionData: $reportTask.executionData.asPath")
        logger.info("  sourceDirectories: $reportTask.sourceDirectories.asPath")
        logger.info("  csv.destination: $reportTask.reports.csv.destination")
        logger.info("  xml.destination: $reportTask.reports.xml.destination")
        logger.info("  html.destination: $reportTask.reports.html.destination")
    }
}
 