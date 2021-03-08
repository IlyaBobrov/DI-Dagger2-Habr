package com.rsttur.tester

import android.annotation.SuppressLint
import android.app.Dialog
import android.app.ProgressDialog
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.rsttur.tester.adapter.RandomUserAdapter
import com.rsttur.tester.interfaces.RandomUsersApi
import com.rsttur.tester.model.Example
import com.rsttur.tester.model.Result
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    val TAG = "TAG"

    lateinit var retrofit: Retrofit
    lateinit var recyclerView: RecyclerView
    lateinit var mAdapter: RandomUserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()

        val gsonBuilder = GsonBuilder()
        val gson: Gson = gsonBuilder.create()

        Timber.plant(Timber.DebugTree())

        val httpLoginInterceptor = HttpLoggingInterceptor(object : HttpLoggingInterceptor.Logger {
            @SuppressLint("LogNotTimber")
            override fun log(message: String) {
//                Timber.i(message)
                Log.e(TAG, "log: $message")
            }
        })

        httpLoginInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

        val okHttpClient = OkHttpClient()
            .newBuilder()
            .addInterceptor(httpLoginInterceptor)
            .build()
        Log.d(TAG, "onCreate: http build true")

        retrofit = Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl("https://randomuser.me")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        Log.d(TAG, "onCreate: retrofit build true")
        populateUsers()
    }

    private fun initViews() {
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.setLayoutManager(LinearLayoutManager(this))
        Log.d(TAG, "initViews: true")
    }

    private fun populateUsers() {
        val dialog: Dialog
        dialog = ProgressDialog.show(this, "", "Loading...", true)
        val randomUsersCall: Call<Example> = getRandomUserService().getRandomUsers(10)
        randomUsersCall.enqueue(object : Callback<Example> {
            override fun onResponse(call: Call<Example>, response: Response<Example>) {
                if (response.isSuccessful()) {
                    Log.d(TAG, "onResponse: success")
                    Log.d(TAG, "onResponse: ${response.body()?.results}")
                    mAdapter = RandomUserAdapter()
                    mAdapter.setItems(response.body()?.results as List<Result>)
                    recyclerView.setAdapter(mAdapter)
                    dialog.dismiss()
                }
            }

            override fun onFailure(call: Call<Example>, t: Throwable) {
                Timber.i(t.message)
                Log.e(TAG, "onFailure: $t")
                dialog.dismiss()
                Toast.makeText(this@MainActivity, "$t", Toast.LENGTH_LONG).show()
            }
        })
        Log.d(TAG, "populateUsers: all true")
    }

    fun getRandomUserService(): RandomUsersApi {
        Log.d(TAG, "getRandomUserService: true")
        return retrofit.create(RandomUsersApi::class.java)
    }

}