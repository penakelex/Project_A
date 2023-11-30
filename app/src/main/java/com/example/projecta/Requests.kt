package com.example.projecta

import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText
import io.ktor.http.ContentType
import io.ktor.http.contentType
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

suspend fun loginUser(user: UserLogin, domain: String) : String{
    val client = HttpClient(CIO)
    val response: HttpResponse = client.post(domain + "/user/login"){
        contentType(ContentType.Application.Json)
        setBody(Json.encodeToString(user))
    }
    client.close()
    return response.bodyAsText()
}
suspend fun registerUser(user: UserRegister, domain: String) : String{
    val client = HttpClient(CIO)
    val response: HttpResponse = client.post(domain + "/user/register"){
        contentType(ContentType.Application.Json)
        setBody(Json.encodeToString(user))
    }
    client.close()
    return response.bodyAsText()
}
suspend fun updateUser(user: UserUpdate, domain: String) : String{
    val client = HttpClient(CIO)
    val response: HttpResponse = client.post(domain + "/user/update")    {
        contentType(ContentType.Application.Json)
        setBody(Json.encodeToString(user))
    }
    client.close()
    return response.bodyAsText()
}