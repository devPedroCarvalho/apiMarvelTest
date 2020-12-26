package test.test.apimarveltest.remoteDataSource.response.list

import com.google.gson.annotations.SerializedName

data class CharacterListResponse(
    @SerializedName("code")
    val code: Int,
    @SerializedName("data")
    val `data`: Data
)