package test.test.apimarveltest.remoteDataSource.repository.details

import test.test.apimarveltest.remoteDataSource.MarvelServices
import javax.inject.Inject

class CharacterDetailsRepository @Inject constructor(
        private val apiService: MarvelServices
): ICharacterDetailsRepository {

    override suspend fun getDetailsCharacter(id: Int) = apiService.getDetailsCharacter(id = id)

}