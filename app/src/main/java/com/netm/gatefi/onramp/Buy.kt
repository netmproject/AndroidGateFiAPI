// Copyright (c) 2024 NetM
// Distributed under the MIT software license, see the accompanying
// file COPYING or http://www.opensource.org/licenses/mit-license.php.

package com.netm.gatefi.onramp

import com.google.gson.annotations.SerializedName

data class Buy(@SerializedName("enabled") val enabled: Boolean,
               @SerializedName("authentication") val authentication: Authentication,
               @SerializedName("redirectOrderId") val redirectOrderId : List<String>,
               @SerializedName("orderCustomId") val orderCustomId : Boolean,
               @SerializedName("browser") val browser : String,
               @SerializedName("userAgent") val userAgent : String){


}
