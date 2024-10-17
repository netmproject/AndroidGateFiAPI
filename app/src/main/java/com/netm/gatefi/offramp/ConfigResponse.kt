// Copyright (c) 2024 NetM
// Distributed under the MIT software license, see the accompanying
// file COPYING or http://www.opensource.org/licenses/mit-license.php.

package com.netm.gatefi.offramp

import com.google.gson.annotations.SerializedName


data class ConfigResponse(@SerializedName("version") var version: String,
                          @SerializedName("updatedAt") var updatedAt: String,
                          @SerializedName("features") var features: Feature,
                          @SerializedName("countries") var countries: List<Country>,
                          @SerializedName("payments") var payments: List<Payment>,
                          @SerializedName("fiat") var fiat: List<Fiat>,
                          @SerializedName("crypto") var crypto:List<Crypto>){


}
