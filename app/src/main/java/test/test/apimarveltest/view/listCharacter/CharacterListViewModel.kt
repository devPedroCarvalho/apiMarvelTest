package test.test.apimarveltest.view.listCharacter

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import test.test.apimarveltest.remoteDataSource.ApiService
import test.test.apimarveltest.remoteDataSource.model.CharacterModel
import test.test.apimarveltest.remoteDataSource.response.list.CharacterListResponse
import test.test.apimarveltest.utils.showAlert

class CharacterListViewModel(
        context: Context?
): ViewModel() {

    private val _characterLiveData = MutableLiveData<MutableList<CharacterModel>>()
    val characterLiveData: MutableLiveData<MutableList<CharacterModel>> = _characterLiveData

    val contextViewModel = context

    fun getListCharacter(){
        ApiService.service.getListCharacter().enqueue(object: Callback<CharacterListResponse> {
            override fun onFailure(call: Call<CharacterListResponse>, t: Throwable) {
                showAlert(contextViewModel, t.message)
            }

            override fun onResponse(
                call: Call<CharacterListResponse>,
                response: Response<CharacterListResponse>
            ) {

                if (response.isSuccessful){

                    val listCharacter: MutableList<CharacterModel> = mutableListOf()

                    response.body()?.let {
                        for (results in it.data.results){
                            val listCharacterModel = CharacterModel(
                                id = results.id,
                                name = results.name
                            )
                            listCharacter.add(listCharacterModel)
                        }
                    }
                    _characterLiveData.value = listCharacter

                }else {
                    showAlert(contextViewModel, "${response.code()} ${response.message()}")
                }
            }

        })
    }
}