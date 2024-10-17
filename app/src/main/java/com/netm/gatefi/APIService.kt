// Copyright (c) 2024 NetM
// Distributed under the MIT software license, see the accompanying
// file COPYING or http://www.opensource.org/licenses/mit-license.php.

package com.netm.gatefi

import com.netm.gatefi.offramp.ConfigResponse
import com.netm.gatefi.offramp.OrderStatusResponses
import com.netm.gatefi.offramp.QuoteResponses
import com.netm.gatefi.offramp.SellResponse
import com.netm.gatefi.onramp.BuyResponse
import com.netm.gatefi.onramp.ConfigurationResponse
import com.netm.gatefi.onramp.OrderListResponse
import com.netm.gatefi.onramp.OrderStatusResponse
import com.netm.gatefi.onramp.QuoteResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url

interface APIService {
    //@Headers("Accept: application/json")
   // @GET
   // suspend fun getConfigu(@Url url:String):Response<ConfigurationResponse>

    //onramp

    @GET("onramp/v1/configuration")
    suspend fun getConfiguration():Response<ConfigurationResponse>

    @GET("onramp/v1/quotes")
    suspend fun getQuote(@Query("amount") amount: String, @Query("crypto") crypto: String,
                         @Query("fiat") fiat: String, @Query("partnerAccountId") partnerAccountId: String,
                         @Query("payment") payment: String, @Query("region") region: String):Response<QuoteResponse>

    @GET("onramp/v1/buy")
    suspend fun getBuy(@Query("cancelUrl") cancelUrl: String, @Query("declineUrl") declineUrl: String,
                       @Query("amount") amount: String, @Query("crypto") crypto: String,
                       @Query("fiat") fiat: String, @Query("orderCustomId") orderCustomId: String,
                       @Query("partnerAccountId") partnerAccountId: String, @Query("payment") payment: String,
                       @Query("redirectUrl") redirectUrl: String, @Query("region") region: String, @Query("walletAddress") walletAddress: String):Response<BuyResponse>

    @GET("onramp/v1/orders/{orderId}")
    suspend fun getStatusOrder(@Path("orderId") orderId:String, @Query("walletAddress") walletAddress: String):Response<OrderStatusResponse>

    @GET("onramp/v1/orders")
    suspend fun getListOrders(@Query("end") end: String, @Query("end") limit: Int, @Query("skip") skip: Int, @Query("start") start: String):Response<OrderListResponse>

    //offramp

    @GET("offramp/v1/configuration")
    suspend fun getConfigurations():Response<ConfigResponse>

    @GET("onramp/v1/sell")
    suspend fun getSell(@Query("amount") amount: Double, @Query("crypto") crypto: String,
                       @Query("fiat") fiat: String, @Query("orderCustomId") orderCustomId: String,
                       @Query("partnerAccountId") partnerAccountId: String, @Query("payment") payment: String,
                       @Query("region") region: String):Response<SellResponse>


    @GET("offramp/v1/quotes")
    suspend fun getQuotes(@Query("crypto") crypto: String, @Query("fiat") fiat: String, @Query("partnerAccountId") partnerAccountId: String, @Query("payment") payment: String,
                          @Query("region") region: String, @Query("calcByFiat") calcByFiat: Boolean, @Query("cryptoAmount") cryptoAmount: String, @Query("fiatAmount") fiatAmount: Int):Response<QuoteResponses>

    @GET("offramp/v1/orders/{orderCustomId}")
    suspend fun getStatusOrders(@Path("orderCustomId") orderCustomId:String):Response<OrderStatusResponses>


}