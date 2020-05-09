package com.jml.breaking.bad

import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import java.io.File


// PUBLIC API ---
fun MockWebServer.mockHttpResponse(body: String, responseCode: Int) = enqueue(
    MockResponse()
        .setResponseCode(responseCode)
        .setBody(body))

// UTILS ---
fun Any.getJson(path: String): String {
    val uri = javaClass.classLoader?.getResource(path)
    val file = File(uri?.path.orEmpty())
    return String(file.readBytes())
}