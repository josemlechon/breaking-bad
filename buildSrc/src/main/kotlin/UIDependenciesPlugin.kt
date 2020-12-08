import com.jml.breaking.bad.Versions
import org.gradle.api.Plugin
import org.gradle.api.Project

class UIDependenciesPlugin : Plugin<Project> {
    override fun apply(project: Project) {

    }

    companion object {
        const val RECYCLERVIEW = "androidx.recyclerview:recyclerview:${Versions.UI.RECYCLER}"
        const val CARDVIEW = "androidx.cardview:cardview:${Versions.UI.CARD}"
        const val CONSTRAINT_LAYOUT =
            "androidx.constraintlayout:constraintlayout:${Versions.UI.CONSTRAINT}"
        const val DESIGN_MATERIAL = "com.google.android.material:material:${Versions.UI.DESIGN}"
        const val APPCOMPAT = "androidx.appcompat:appcompat:${Versions.UI.APPCOMPAT}"
        const val GRIDLAYOUT = "androidx.gridlayout:gridlayout:${Versions.UI.GRIDLAYOUT}"
    }
}