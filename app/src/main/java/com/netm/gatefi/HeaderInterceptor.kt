// Copyright (c) 2024 NetM
// Distributed under the MIT software license, see the accompanying
// file COPYING or http://www.opensource.org/licenses/mit-license.php.

package com.netm.gatefi

import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .addHeader(
            "Accept:",  "application/json"
        )
            .addHeader(
                "api-key:",  "123"
            )

            .addHeader(
                "signature::",  "2b6b6c58d175ec6bd13c92a17d262fce9336fe1bb41fc1bae0753927c0bbcf2d"
            )
            .build()

        return chain.proceed(request)
    }
}