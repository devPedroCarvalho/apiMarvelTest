package test.test.apimarveltest.remoteDataSource

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import test.test.apimarveltest.remoteDataSource.response.details.CharacterDetailsResponse
import test.test.apimarveltest.remoteDataSource.response.list.CharacterListResponse

interface MarvelServices {


    @GET("/v1/public/characters")
    fun getListCharacter(
        @Query("ts") ts: String = "1",
        @Query("apikey") apikey: String = "71bab1d5e04f966286afde5e1812601c",
        @Query("hash") hash: String = "d48e7331e1451aae707194a1e2d766d0"
    ): Call<CharacterListResponse>


    @GET("/v1/public/characters/{id}")
    fun getDetailsCharacter(
        @Path("id") id: Int,
        @Query("ts") ts: String = "1",
        @Query("apikey") apikey: String = "71bab1d5e04f966286afde5e1812601c",
        @Query("hash") hash: String = "d48e7331e1451aae707194a1e2d766d0"
    ): Call<CharacterDetailsResponse>

}