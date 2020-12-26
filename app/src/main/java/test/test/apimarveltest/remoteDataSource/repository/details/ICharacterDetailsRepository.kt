package test.test.apimarveltest.remoteDataSource.repository.details

import retrofit2.Response
import test.test.apimarveltest.remoteDataSource.response.details.CharacterDetailsResponse


interface ICharacterDetailsRepository {

     suspend fun getDetailsCharacter(id: Int): Response<CharacterDetailsResponse>
}