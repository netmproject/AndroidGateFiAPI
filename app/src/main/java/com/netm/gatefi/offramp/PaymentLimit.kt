// Copyright (c) 2024 NetM
// Distributed under the MIT software license, see the accompanying
// file COPYING or http://www.opensource.org/licenses/mit-license.php.

package com.netm.gatefi.offramp

import com.google.gson.annotations.SerializedName

data class PaymentLimit(@SerializedName("id") var id: String,
                        @SerializedName("currency") var currency: String,
                        @SerializedName("min") var min: String,
                        @SerializedName("max") var max: String,
                        @SerializedName("minCrypto") var minCrypto: String,
                        @SerializedName("maxCrypto") var maxCrypto: String){

}
