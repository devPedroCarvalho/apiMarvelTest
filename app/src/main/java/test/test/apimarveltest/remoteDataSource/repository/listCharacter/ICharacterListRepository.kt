package test.test.apimarveltest.remoteDataSource.repository.listCharacter

import retrofit2.Response
import test.test.apimarveltest.remoteDataSource.response.list.CharacterListResponse

interface ICharacterListRepository {

    suspend fun getListCharacter(): Response<CharacterListResponse>

}