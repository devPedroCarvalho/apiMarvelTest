package test.test.apimarveltest.view.details

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import test.test.apimarveltest.remoteDataSource.ApiService
import test.test.apimarveltest.remoteDataSource.model.DetailsModel
import test.test.apimarveltest.remoteDataSource.response.details.CharacterDetailsResponse

class CharacterDetailsViewModel: ViewModel() {

    private val _detailsLiveData = MutableLiveData<DetailsModel>()
    val detailsLiveData: MutableLiveData<DetailsModel> = _detailsLiveData

    fun getDetailsCharacter(id: Int){
        ApiService.service.getDetailsCharacter(id = id).enqueue(object: Callback<CharacterDetailsResponse> {
            override fun onFailure(call: Call<CharacterDetailsResponse>, t: Throwable) {
                print(t)

            }

            override fun onResponse(
                call: Call<CharacterDetailsResponse>,
                response: Response<CharacterDetailsResponse>
            ) {

                val resp = response.body()
                print(resp)
                if (response.isSuccessful){

                    response.body()?.let{
                        val model = DetailsModel(
                            name = it.data.results[0].name,
                            description = it.data.results[0].description,
                            image = it.data.results[0].thumbnail.path,
                            extension = it.data.results[0].thumbnail.extension
                        )
                        _detailsLiveData.value = model
                    }
                }
            }

        })
    }
}

