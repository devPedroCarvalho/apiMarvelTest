package test.test.apimarveltest.view.details


import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import test.test.apimarveltest.remoteDataSource.model.DetailsModel
import test.test.apimarveltest.remoteDataSource.repository.ICharacterDetailsRepository

class CharacterDetailsViewModel @ViewModelInject constructor(
    private val repository: ICharacterDetailsRepository,
): ViewModel() {


    var servicesLiveData: MutableLiveData<DetailsModel>? = null

    fun getDetailsCharacter(id: Int) : LiveData<DetailsModel>? {
        servicesLiveData = repository.getDetailsCharacter(id = id)
        return servicesLiveData
    }

}

