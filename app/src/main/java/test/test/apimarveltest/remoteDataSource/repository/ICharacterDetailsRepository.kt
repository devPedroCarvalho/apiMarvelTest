package test.test.apimarveltest.remoteDataSource.repository

import androidx.lifecycle.MutableLiveData
import test.test.apimarveltest.remoteDataSource.model.DetailsModel


interface ICharacterDetailsRepository {

     fun getDetailsCharacter(id: Int): MutableLiveData<DetailsModel>
}