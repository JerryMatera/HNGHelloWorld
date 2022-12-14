package io.github.jerrymatera.hnghelloworld.data.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import io.github.jerrymatera.hnghelloworld.data.model.Post
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET


interface PostService {
    @GET("/posts")
    suspend fun getPosts(): Response<List<Post>>

}

object PostApi {
    private const val BASE_URL = "https://jsonplaceholder.typicode.com"

    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .baseUrl(BASE_URL)
        .build()

    val retrofitService: PostService by lazy {
        retrofit.create(PostService::class.java)
    }
}