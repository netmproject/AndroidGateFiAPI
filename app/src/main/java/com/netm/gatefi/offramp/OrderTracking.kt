// Copyright (c) 2024 NetM
// Distributed under the MIT software license, see the accompanying
// file COPYING or http://www.opensource.org/licenses/mit-license.php.

package com.netm.gatefi.offramp

import com.google.gson.annotations.SerializedName

data class OrderTracking(@SerializedName("enabled") val enabled: Boolean){

}
