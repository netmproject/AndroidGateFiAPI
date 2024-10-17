// Copyright (c) 2024 NetM
// Distributed under the MIT software license, see the accompanying
// file COPYING or http://www.opensource.org/licenses/mit-license.php.

package com.netm.gatefi.onramp

import com.google.gson.annotations.SerializedName

data class PaymentLimit(@SerializedName("id") var id: String,
                        @SerializedName("min") var min: String,
                        @SerializedName("max") var max: String){

}
