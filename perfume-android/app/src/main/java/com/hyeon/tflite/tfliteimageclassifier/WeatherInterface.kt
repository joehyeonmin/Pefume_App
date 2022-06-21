package com.hyeon.tflite.tfliteimageclassifier

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

// 결과 xml 파일에 접근해서 정보 가져오기
interface WeatherInterface {
    // getVilageFcst : 단기예보조회
    // @Headers("Content-Type: application/json")
    @GET("getVilageFcst?serviceKey=****")

    fun GetWeather(@Query("numOfRows") num_of_rows : Int,
                   @Query("pageNo") page_no : Int,
                   @Query("dataType") data_type : String,
                   @Query("base_date") base_date : String,
                   @Query("base_time") base_time : String,
                   @Query("nx") nx : Int,
                   @Query("ny") ny : Int
    ): Call<WEATHER>
}
