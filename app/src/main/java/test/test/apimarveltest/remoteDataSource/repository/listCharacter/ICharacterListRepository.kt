package test.test.apimarveltest.remoteDataSource.repository.listCharacter

import androidx.lifecycle.MutableLiveData
import test.test.apimarveltest.remoteDataSource.model.CharacterModel

interface ICharacterListRepository {

    fun getListCharacter(): MutableLiveData<MutableList<CharacterModel>>

}