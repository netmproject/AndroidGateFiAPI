// Copyright (c) 2024 NetM
// Distributed under the MIT software license, see the accompanying
// file COPYING or http://www.opensource.org/licenses/mit-license.php.

package com.netm.gatefi.onramp

import com.google.gson.annotations.SerializedName

data class Payment(@SerializedName("id") val id: String,
                   @SerializedName("availableFiatCurrencies") val availableFiatCurrencies : List<String>,
                   @SerializedName("availableCountries") val availableCountries : List<String>){

}
