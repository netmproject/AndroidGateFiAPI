// Copyright (c) 2024 NetM
// Distributed under the MIT software license, see the accompanying
// file COPYING or http://www.opensource.org/licenses/mit-license.php.

package com.netm.gatefi.offramp

import com.google.gson.annotations.SerializedName


data class Feature(@SerializedName("quotes") val quotes: Quote,
                   @SerializedName("buy") val buy: String?,
                   @SerializedName("orderTracking") val orderTracking: OrderTracking,
                   @SerializedName("orderAnalytics") val orderAnalytics: OrderAnalytic,
                   @SerializedName("sell") val sell: Sell){

}
