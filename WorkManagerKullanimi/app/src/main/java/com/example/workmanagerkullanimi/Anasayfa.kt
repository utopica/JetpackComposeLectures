package com.example.workmanagerkullanimi

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TimeInput
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import java.util.concurrent.TimeUnit

@OptIn(ExperimentalMaterial3Api::class, ExperimentalPermissionsApi::class)
@Composable
fun Anasayfa(){

    val context = LocalContext.current
    val izinKontrol = rememberPermissionState(permission = android.Manifest.permission.ACCESS_FINE_LOCATION)

    Scaffold (
        topBar = { TopAppBar(title = { Text(text = "Anasayfa") })}
    ){
        paddingValues ->

        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Button(onClick = {
                val calismaKosulu = Constraints.Builder() //androidx.work
                    .setRequiredNetworkType(NetworkType.CONNECTED)
                    .build()

                val istek = OneTimeWorkRequestBuilder<MyWorkerBildirim>() //MyWorker / MyWorkerBildirim
                    .setInitialDelay(10, TimeUnit.SECONDS)
                    .setConstraints(calismaKosulu)
                    .build() //çalıştımak istediğim classı yazdım
                WorkManager.getInstance(context).enqueue(istek)
            }) {
                Text(text = "Yap")
            }

            Button(onClick = {
                val calismaKosulu = Constraints.Builder() //androidx.work
                    .setRequiredNetworkType(NetworkType.CONNECTED)
                    .build()

                val istek = OneTimeWorkRequestBuilder<MyWorkerBildirim>() //MyWorker / MyWorkerBildirim
                    .setInitialDelay(10, TimeUnit.SECONDS)
                    .setConstraints(calismaKosulu)
                    .build() //çalıştımak istediğim classı yazdım
                WorkManager.getInstance(context).enqueue(istek)

                if(izinKontrol.status.isGranted){
                    Toast.makeText(context, "Daha önce izin verildi", Toast.LENGTH_SHORT).show()
                }else{
                    izinKontrol.launchPermissionRequest()
                }
            }) {
                Text(text = "İzin Al")


            }
        }
    }
}