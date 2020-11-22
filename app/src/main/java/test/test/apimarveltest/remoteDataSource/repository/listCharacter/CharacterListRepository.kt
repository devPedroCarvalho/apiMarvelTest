package test.test.apimarveltest.remoteDataSource.repository.listCharacter

import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import test.test.apimarveltest.remoteDataSource.MarvelServices
import test.test.apimarveltest.remoteDataSource.model.CharacterModel
import test.test.apimarveltest.remoteDataSource.response.list.CharacterListResponse
import javax.inject.Inject

class CharacterListRepository @Inject constructor(
        private val apiService: MarvelServices
): ICharacterListRepository {

    val characterLiveData = MutableLiveData<MutableList<CharacterModel>>()

    override fun getListCharacter(): MutableLiveData<MutableList<CharacterModel>> {
        apiService.getListCharacter().enqueue(object: Callback<CharacterListResponse> {
            override fun onFailure(call: Call<CharacterListResponse>, t: Throwable) {
               // showAlert(contextViewModel, t.message)
                //TODO
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
                    characterLiveData.value = listCharacter

                }else {
                   // showAlert(contextViewModel, "${response.code()} ${response.message()}")
                    //TODO
                }
            }

        })
        return characterLiveData
    }
}