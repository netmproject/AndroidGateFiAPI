// Copyright (c) 2024 NetM
// Distributed under the MIT software license, see the accompanying
// file COPYING or http://www.opensource.org/licenses/mit-license.php.

package com.netm.gatefi.onramp

import com.google.gson.annotations.SerializedName

data class OrderStatusResponse(@SerializedName("id") var id: String,
                               @SerializedName("customId") var customId: String,
                               @SerializedName("userId") var userId:String,
                               @SerializedName("link") var link:String,
                               @SerializedName("crypto") var crypto:Crypto,
                               @SerializedName("fiatAmountInUsd") var fiatAmountInUsd:String,
                               @SerializedName("fiat") var fiat: String,
                               @SerializedName("payment") var payment: String,
                               @SerializedName("providerPayment") var providerPayment:String,
                               @SerializedName("cryptoAmountOut") var cryptoAmountOut: String,
                               @SerializedName("fiatAmountIn") var fiatAmountIn:String,
                               @SerializedName("exchangeRate") var exchangeRate:String,
                               @SerializedName("processingFees") var processingFees:List<ProcessingFee>,
                               @SerializedName("networkFees") var networkFees:List<NetworkFee>,
                               @SerializedName("partnerFees") var partnerFees:List<PartnerFee>,
                               @SerializedName("createdAt") var createdAt: String,
                               @SerializedName("updatedAt") var updatedAt:String,
                               @SerializedName("transactionHash") var transactionHash:String,
                               @SerializedName("walletAddress") var walletAddress:String,
                               @SerializedName("status") var status:String,
                               @SerializedName("statusCode") var statusCode:String,
                               @SerializedName("statusReason") var statusReason: String,
                               @SerializedName("partnerAccountId") var partnerAccountId: String,
                               @SerializedName("orderType") var orderType: String){


}
