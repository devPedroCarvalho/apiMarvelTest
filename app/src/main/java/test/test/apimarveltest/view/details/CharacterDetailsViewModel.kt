package test.test.apimarveltest.view.details


import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import test.test.apimarveltest.remoteDataSource.model.DetailsModel
import test.test.apimarveltest.remoteDataSource.repository.details.ICharacterDetailsRepository

class CharacterDetailsViewModel @ViewModelInject constructor(
        private val repository: ICharacterDetailsRepository,
): ViewModel() {


    var detailsModelLiveData: MutableLiveData<DetailsModel>? = null

    fun getDetailsCharacter(id: Int) : LiveData<DetailsModel>? {
        detailsModelLiveData = repository.getDetailsCharacter(id = id)
        return detailsModelLiveData
    }

}

