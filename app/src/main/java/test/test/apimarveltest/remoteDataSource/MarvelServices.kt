package test.test.apimarveltest.remoteDataSource

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import test.test.apimarveltest.Utils
import test.test.apimarveltest.remoteDataSource.response.details.CharacterDetailsResponse
import test.test.apimarveltest.remoteDataSource.response.list.CharacterListResponse

interface MarvelServices {


    @GET("/v1/public/characters")
    fun getListCharacter(
        @Query(Utils.TS) ts: Int = Utils.TS_VALUE,
        @Query(Utils.API_KEY) apikey: String = Utils.API_KEY_VALUE,
        @Query(Utils.HASH) hash: String = Utils.HASH_VALUE
    ): Call<CharacterListResponse>


    @GET("/v1/public/characters/{id}")
    fun getDetailsCharacter(
        @Path("id") id: Int,
        @Query(Utils.TS) ts: Int = Utils.TS_VALUE,
        @Query(Utils.API_KEY) apikey: String = Utils.API_KEY_VALUE,
        @Query(Utils.HASH) hash: String = Utils.HASH_VALUE
    ): Call<CharacterDetailsResponse>

}