package test.test.apimarveltest.view.listCharacter

import androidx.hilt.lifecycle.ViewModelInject

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers
import test.test.apimarveltest.remoteDataSource.repository.listCharacter.ICharacterListRepository
import test.test.apimarveltest.remoteDataSource.resource.Resource

class CharacterListViewModel @ViewModelInject constructor(
        private val repository: ICharacterListRepository
): ViewModel() {


    fun getDetailsCharacter() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = repository.getListCharacter()))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }
}