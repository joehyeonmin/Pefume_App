package com.hyeon.tflite.tfliteimageclassifier

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// retrofit을 사용하기 위한 빌더 생성
var gson = GsonBuilder().setLenient().create()

val retrofit = Retrofit.Builder()
    .baseUrl("http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

object ApiObject {
    val retrofitService: WeatherInterface by lazy {
        retrofit.create(WeatherInterface::class.java)
    }
}

// 로그 확인하기 위해서 테스트
val loggingInterceptor = HttpLoggingInterceptor().apply {
    level = HttpLoggingInterceptor.Level.BODY
}
var client : OkHttpClient = OkHttpClient.Builder().addInterceptor(loggingInterceptor).build()

object WeatherObject {
    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/")
            .client(client)  // 테스트
            .addConverterFactory(GsonConverterFactory.create(gson)) // Json데이터를 사용자가 정의한 Java 객체로 변환해주는 라이브러리
            .build()
    }

    fun getRetrofitService(): WeatherInterface {
        return getRetrofit().create(WeatherInterface::class.java) // retrofit객체 만듦
    }
}