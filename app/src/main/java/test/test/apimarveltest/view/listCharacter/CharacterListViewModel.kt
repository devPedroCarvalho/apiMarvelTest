package test.test.apimarveltest.view.listCharacter

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import test.test.apimarveltest.remoteDataSource.model.CharacterModel
import test.test.apimarveltest.remoteDataSource.repository.listCharacter.ICharacterListRepository

class CharacterListViewModel @ViewModelInject constructor(
        private val repository: ICharacterListRepository
): ViewModel() {

    fun getDetailsCharacter() : LiveData<MutableList<CharacterModel>>? {
        return repository.getListCharacter()
    }
}