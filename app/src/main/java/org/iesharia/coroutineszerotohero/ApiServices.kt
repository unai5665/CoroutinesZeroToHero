package org.iesharia.coroutineszerotohero

import com.google.gson.annotations.SerializedName
import retrofit2.Response
import retrofit2.http.GET

interface ApiServices {

    @GET("https://jsonplaceholder.typicode.com/users")
    suspend fun getUsers(): Response<List<UserResponse>>
}

data class UserResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("username") val username: String,
    @SerializedName("email") val email: String,
    @SerializedName("address") val address: AddressResponse,
    @SerializedName("phone") val phone: String,
    @SerializedName("website") val website: String,
    @SerializedName("company") val company: CompanyResponse
)

data class AddressResponse(
    @SerializedName("street") val street: String,
    @SerializedName("suite") val suite: String,
    @SerializedName("city") val city: String,
    @SerializedName("zipcode") val zipcode: String,
    @SerializedName("geo") val geo: GeoResponse
)

data class GeoResponse(
    @SerializedName("lat") val lat: String,
    @SerializedName("lng") val lng: String
)

data class CompanyResponse(
    @SerializedName("name") val name: String,
    @SerializedName("catchPhrase") val catchPhrase: String,
    @SerializedName("bs") val bs: String
)
