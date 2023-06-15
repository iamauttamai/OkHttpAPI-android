package com.iamauttamai.okhttpapi

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.iamauttamai.okhttpapi.api.APICloud
import okhttp3.*
import java.io.IOException
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        callService()

    }

    private fun callService() {
        val client = OkHttpClient()
        val formBody: RequestBody = FormBody.Builder()
            .add("param", "value")
            .build()
        val request: Request = APICloud().GetService(formBody)
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                e.printStackTrace()
                Log.i("okhttp", "fail")
            }

            @SuppressLint("NotifyDataSetChanged")
            @Throws(IOException::class)
            override fun onResponse(call: Call, response: Response) {
                Log.i("okhttp", "success")
            }
        })
    }
}