//package com.angkorteam.uicompose.master.model
//
//import android.util.Log
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.liveData
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.delay
//import kotlinx.coroutines.withContext
//import okhttp3.OkHttpClient
//import okhttp3.Request
//
//class TestViewModel : ViewModel() {
//
//    fun test() = liveData {
//        withContext(Dispatchers.IO) {
//            emit(-1)
//            delay(2000)
//            val pp = OkHttpClient()
//            val ss =
//                pp.newCall(
//                    Request.Builder().get().url("http://192.168.1.10/page01.json").build()
//                )
//                    .execute()
//            ss.use {
//                ss.body?.close()
//                Log.i("THREAD", "Code " + ss.code.toString())
//            }
//            emit(ss.code)
//        }
//    }
//}