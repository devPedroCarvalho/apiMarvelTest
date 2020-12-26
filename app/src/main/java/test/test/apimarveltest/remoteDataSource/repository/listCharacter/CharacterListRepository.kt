package test.test.apimarveltest.remoteDataSource.repository.listCharacter

import test.test.apimarveltest.remoteDataSource.MarvelServices
import javax.inject.Inject

class CharacterListRepository @Inject constructor(
        private val apiService: MarvelServices
): ICharacterListRepository {

    override suspend fun getListCharacter() = apiService.getListCharacter()

}