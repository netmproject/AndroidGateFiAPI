// Copyright (c) 2024 NetM
// Distributed under the MIT software license, see the accompanying
// file COPYING or http://www.opensource.org/licenses/mit-license.php.

package com.netm.gatefi

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.netm.gatefi.offramp.ConfigResponse
import com.netm.gatefi.offramp.OrderStatusResponses
import com.netm.gatefi.offramp.QuoteResponses
import com.netm.gatefi.offramp.SellResponse
import com.netm.gatefi.onramp.BuyResponse
import com.netm.gatefi.onramp.ConfigurationResponse
import com.netm.gatefi.onramp.OrderListResponse
import com.netm.gatefi.onramp.OrderStatusResponse
import com.netm.gatefi.onramp.QuoteResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Composable
fun MenuView(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Menu")

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = { navController.navigate("configuration") }) {
            Text("Configuration")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = { navController.navigate("quotes") }) {
            Text("Quotes")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = { navController.navigate("orders") }) {
            Text("Orders")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = { navController.navigate("order") }) {
            Text("Order")
        }
    }
}

@Composable
fun ConfigurationView(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
           getConfiguration()
        }) {
            Text("Get Configuration")
        }
        /*
        Button(onClick = {
            navController.navigate("view3") {
                // This will remove Configuration from the stack
                popUpTo("configuration") { inclusive = true }
            }
        }) {
            Text("Go to other Screen")
        }
         */
    }
}

@Composable
fun QuotesView(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Button(onClick = {
            getQuotes("BTC", "USD", "testID", "GOOGLEPAY", "US", true, "0.00148473", 100)
        }) {
            Text("Get Quotes")
        }
    }
}

@Composable
fun OrdersView(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = {
            getOrderList("10/16/2024", 1000, 0, "10/10/2024")
        }) {
            Text("Get Orders")
        }
    }
}

@Composable
fun OrderView(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = {
            getStatusOrders("10632")
        }) {
            Text("Get Order")
        }
    }
}



private fun getRetrofit(): Retrofit {

    return Retrofit.Builder()
        .baseUrl("https://api-sandbox.gatefi.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(getClient())
        .build()
}

private fun getClient(): OkHttpClient {
    val client = OkHttpClient.Builder()
        .addInterceptor(HeaderInterceptor())
        .build()

    return client
}

//OnRamp

private fun getConfiguration(){
    CoroutineScope(Dispatchers.IO).launch {
        val call =
            getRetrofit().create(APIService::class.java).getConfiguration()
        val config: ConfigurationResponse? = call.body()

        if(call.isSuccessful){
            //Show RecycleView
            print(config)
        }
        else{
            //Error
            print("Error with Configuration")
        }

    }

}

private fun getBuy(cancelUrl: String, declineUrl: String, amount: String, crypto: String, fiat: String,
                   orderCustomId: String, partnerAccountId: String, payment: String, redirectUrl: String,
                   region: String, walletAddress: String){
    CoroutineScope(Dispatchers.IO).launch {
        val call =
            getRetrofit().create(APIService::class.java).getBuy(cancelUrl, declineUrl, amount, crypto, fiat,
                orderCustomId, partnerAccountId, payment, redirectUrl,
                region, walletAddress)
        val config: BuyResponse? = call.body()

        if(call.isSuccessful){
            //Show RecycleView
        }
        else{
            //Error
            print("Error with Buy")
        }

    }

}

private fun getQuote(amount: String, crypto: String, fiat: String, partnerAccountId: String,
                     payment: String, region: String){
    CoroutineScope(Dispatchers.IO).launch {
        val call =
            getRetrofit().create(APIService::class.java).getQuote(
                amount, crypto,fiat, partnerAccountId, payment, region)
        val config: QuoteResponse? = call.body()

        if(call.isSuccessful){
            //Show RecycleView
        }
        else{
            //Error
            print("Error with Quote")
        }

    }

}

private fun getStatusOrder(orderId: String, walletAddress: String){
    CoroutineScope(Dispatchers.IO).launch {
        val call =
            getRetrofit().create(APIService::class.java).getStatusOrder(
                orderId, walletAddress)
        val config: OrderStatusResponse? = call.body()

        if(call.isSuccessful){
            //Show RecycleView
        }
        else{
            //Error
            print("Error with Status Orders")
        }

    }

}

private fun getOrderList(end: String, limit: Int, skip: Int, start: String){
    CoroutineScope(Dispatchers.IO).launch {
        val call =
            getRetrofit().create(APIService::class.java).getListOrders(
                end, limit, skip, start)
        val config: OrderListResponse? = call.body()

        if(call.isSuccessful){
            //Show RecycleView
        }
        else{
            //Error
            print("Error with Order List")
        }

    }

}

//OffRamp

private fun getConfigurations(){
    CoroutineScope(Dispatchers.IO).launch {
        val call =
            getRetrofit().create(APIService::class.java).getConfigurations()
        val config: ConfigResponse? = call.body()

        if(call.isSuccessful){
            //Show RecycleView
        }
        else{
            //Error
            print("Error with Configuration")
        }

    }

}

private fun getSell(amount: Double, crypto: String, fiat: String, orderCustomId: String,
                    partnerAccountId: String, payment: String, region: String){
    CoroutineScope(Dispatchers.IO).launch {
        val call =
            getRetrofit().create(APIService::class.java).getSell(amount, crypto, fiat,
                orderCustomId, partnerAccountId, payment, region)
        val config: SellResponse? = call.body()

        if(call.isSuccessful){
            //Show RecycleView
        }
        else{
            //Error
            print("Error with Sell")
        }

    }

}

private fun getQuotes(crypto: String, fiat: String, partnerAccountId: String, payment: String,
                      region: String, calcByFiat: Boolean, cryptoAmount: String,
                      fiatAmount: Int){
    CoroutineScope(Dispatchers.IO).launch {
        val call =
            getRetrofit().create(APIService::class.java).getQuotes(crypto, fiat, partnerAccountId, payment, region, calcByFiat, cryptoAmount, fiatAmount)
        val config: QuoteResponses? = call.body()

        if(call.isSuccessful){
            //Show RecycleView
        }
        else{
            //Show Error
            print("Error with Quotes")
        }

    }

}

private fun getStatusOrders(orderCustomId: String){
    CoroutineScope(Dispatchers.IO).launch {
        val call =
            getRetrofit().create(APIService::class.java).getStatusOrders(
                orderCustomId)
        val config: OrderStatusResponses? = call.body()

        if(call.isSuccessful){
            //Show RecycleView
        }
        else{
            //Show Error
            print("Error with Status Orders")
        }

    }

}

/*
private fun search(query: String){
    CoroutineScope(Dispatchers.IO).launch {
        val call =
            getRetrofit().create(APIService::class.java).getConfigu("$query/onramp/v1/configuration")
        val config: ConfigurationResponse? = call.body()

        if(call.isSuccessful){
            //Show Message
        }
        else{
            //Show Error
        }

    }

} */
