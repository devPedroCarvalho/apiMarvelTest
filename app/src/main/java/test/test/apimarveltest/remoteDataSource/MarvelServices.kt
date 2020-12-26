package test.test.apimarveltest.remoteDataSource

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import test.test.apimarveltest.utils.Utils
import test.test.apimarveltest.remoteDataSource.response.details.CharacterDetailsResponse
import test.test.apimarveltest.remoteDataSource.response.list.CharacterListResponse

interface MarvelServices {


    @GET("/v1/public/characters")
    suspend fun getListCharacter(
        @Query(Utils.TS) ts: Int = Utils.TS_VALUE,
        @Query(Utils.API_KEY) apikey: String = Utils.API_KEY_VALUE,
        @Query(Utils.HASH) hash: String = Utils.HASH_VALUE
    ): Response<CharacterListResponse>


    @GET("/v1/public/characters/{id}")
   suspend fun getDetailsCharacter(
        @Path("id") id: Int,
        @Query(Utils.TS) ts: Int = Utils.TS_VALUE,
        @Query(Utils.API_KEY) apikey: String = Utils.API_KEY_VALUE,
        @Query(Utils.HASH) hash: String = Utils.HASH_VALUE
    ): Response<CharacterDetailsResponse>

}