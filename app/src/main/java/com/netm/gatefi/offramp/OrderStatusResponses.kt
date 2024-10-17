// Copyright (c) 2024 NetM
// Distributed under the MIT software license, see the accompanying
// file COPYING or http://www.opensource.org/licenses/mit-license.php.

package com.netm.gatefi.offramp

import com.google.gson.annotations.SerializedName


data class OrderStatusResponses(@SerializedName("id") var id: String,
                                @SerializedName("customId") var customId: String,
                                @SerializedName("userId") var userId: String,
                                @SerializedName("link") var link: String,
                                @SerializedName("crypto") var crypto: Crypto,
                                @SerializedName("cryptoAmountIn") var cryptoAmountIn:String,
                                @SerializedName("cryptoAmountInFiat") var cryptoAmountInFiat:String,
                                @SerializedName("fiat") var fiat: String,
                                @SerializedName("fiatAmountOut") var fiatAmountOut: String,
                                @SerializedName("exchangeRate") var exchangeRate: String,
                                @SerializedName("processingFees") var processingFees:List<ProcessingFee>,
                                @SerializedName("partnerFees") var partnerFees:List<PartnerFee>,
                                @SerializedName("createdAt") var createdAt:String,
                                @SerializedName("updatedAt") var updatedAt:String,
                                @SerializedName("unlimitWalletAddress") var unlimitWalletAddress:String,
                                @SerializedName("userWalletAddress") var userWalletAddress: String,
                                @SerializedName("status") var status:String,
                                @SerializedName("partnerAccountId") var partnerAccountId:String,
                                @SerializedName("orderType") var orderType:String,
                                @SerializedName("feesInUsd") var feesInUsd:FeesInUsd){



}
