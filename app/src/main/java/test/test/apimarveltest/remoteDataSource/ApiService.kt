package test.test.apimarveltest.remoteDataSource

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import test.test.apimarveltest.utils.Utils

object ApiService {

    private fun initRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Utils.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val service = initRetrofit().create(MarvelServices::class.java)
}