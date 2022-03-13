package com.behzoddev.e_wallet.data.remote


import com.behzoddev.e_wallet.data.local.RoomContract
import com.behzoddev.e_wallet.data.remote.model.CurrencyRatesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CurrencyService {

    @GET(RetrofitContract.LATEST)
    suspend fun fetchRates(
        @Query(RetrofitContract.BASE) base: String
    ) : Response<CurrencyRatesResponse>
}