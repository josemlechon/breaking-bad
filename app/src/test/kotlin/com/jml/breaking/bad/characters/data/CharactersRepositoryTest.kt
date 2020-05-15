package com.jml.breaking.bad.characters.data

import com.jml.breaking.bad.characters.data.datasource.CharactersApi
import com.jml.breaking.bad.characters.data.model.CharacterResponse
import com.jml.breaking.bad.characters.domain.model.CharacterSeries
import com.jml.breaking.bad.getJson
import com.jml.breaking.bad.mockHttpResponse
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockWebServer
import org.junit.jupiter.api.*
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.net.HttpURLConnection

// https://medium.com/code-with-lisa/2-minute-time-saver-junit-5-and-android-architecture-components-94312478cd44

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class CharactersRepositoryTest {

    private val path = "json/api/characters.json"

    private lateinit var charactersRepoSUT: CharactersRepository

    private lateinit var mockServer: MockWebServer

    private lateinit var charactersApi: CharactersApi

    @BeforeAll
    fun setUp() {

        mockServer = MockWebServer()
        mockServer.url("/")

        val httpUrl = mockServer.url("/")

        charactersApi = Retrofit.Builder()
            .baseUrl(httpUrl.toString())
            .addConverterFactory(MoshiConverterFactory.create())
            .build().create(CharactersApi::class.java)

        charactersRepoSUT = CharactersRepository(charactersApi)
    }

    @Test
    fun `Validate Api is called and return proper _Response object`() = runBlocking {

        val testDataJson = getJson(path)

        val type = Types.newParameterizedType(
            MutableList::class.java,
            CharacterResponse::class.java
        )

        val adapter = Moshi.Builder().build().adapter<List<CharacterResponse>>(type)
        val testData = adapter.fromJson(testDataJson)!!

        mockServer.mockHttpResponse(testDataJson, HttpURLConnection.HTTP_OK)

        val response = charactersApi.getCharacters()

        Assertions.assertEquals(testData.size, response.size)
    }


    @Test
    @ExperimentalCoroutinesApi
    fun `Verify network error has happened`() = runBlocking {

        /* todo complete this test
        val body = getJson(path)
        mockServer.mockHttpResponse(body, HttpURLConnection.HTTP_BAD_REQUEST)

        // Exercise
        val result: Deferred<List<CharacterSeries>> = async {
            charactersRepoSUT.getCharacters()
        }

        result.start()

         */

    }


    @Test
    fun `verify method does api call and map the result to model object`() = runBlocking {

        val body = getJson(path)
        mockServer.mockHttpResponse(body, HttpURLConnection.HTTP_OK)

        // Exercise
        val result: List<CharacterSeries> = charactersRepoSUT.getCharacters()

        Assertions.assertTrue(result.isNotEmpty())
    }


    @AfterAll
    fun tearDown() {
        mockServer.shutdown()
    }
}