package test.test.apimarveltest.view.details


import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers
import test.test.apimarveltest.remoteDataSource.repository.details.ICharacterDetailsRepository
import test.test.apimarveltest.remoteDataSource.resource.Resource

class CharacterDetailsViewModel @ViewModelInject constructor(
        private val repository: ICharacterDetailsRepository,
): ViewModel() {

    fun getDetailsCharacter(id: Int) = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = repository.getDetailsCharacter(id = id)))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }
}

