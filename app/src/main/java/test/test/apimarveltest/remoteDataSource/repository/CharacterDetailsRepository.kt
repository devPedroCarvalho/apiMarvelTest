package test.test.apimarveltest.remoteDataSource.repository

import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import test.test.apimarveltest.remoteDataSource.MarvelServices
import test.test.apimarveltest.remoteDataSource.model.DetailsModel
import test.test.apimarveltest.remoteDataSource.response.details.CharacterDetailsResponse
import javax.inject.Inject

class CharacterDetailsRepository @Inject constructor(
        private val apiService: MarvelServices
):ICharacterDetailsRepository {

    val detailsLiveData = MutableLiveData<DetailsModel>()

    override fun getDetailsCharacter(id: Int):MutableLiveData<DetailsModel> {

        apiService.getDetailsCharacter(id = id).enqueue(object: Callback<CharacterDetailsResponse> {
            override fun onFailure(call: Call<CharacterDetailsResponse>, t: Throwable) {
                //showAlert(contextViewModel, t.message)
                //TODO
            }

            override fun onResponse(
                    call: Call<CharacterDetailsResponse>,
                    response: Response<CharacterDetailsResponse>
            ) {

                if (response.isSuccessful){

                    response.body()?.let{
                        val modelDetails = DetailsModel(
                                name = it.data.results[0].name,
                                description = it.data.results[0].description,
                                image = it.data.results[0].thumbnail.path,
                                extension = it.data.results[0].thumbnail.extension
                        )
                        detailsLiveData.value = modelDetails
                    }
                }else {
                    //showAlert(contextViewModel, "${response.code()} ${response.message()}")
                    //TODO
                }
            }

        })
        return detailsLiveData

    }


}