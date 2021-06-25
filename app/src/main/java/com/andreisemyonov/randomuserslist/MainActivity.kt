package com.andreisemyonov.randomuserslist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.andreisemyonov.randomuserslist.adapter.Adapter
import com.andreisemyonov.randomuserslist.api.ApiClient
import com.andreisemyonov.randomuserslist.api.ApiInterface
import com.andreisemyonov.randomuserslist.model.Example
import com.andreisemyonov.randomuserslist.model.Result
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    private var resultList: List<Result> = ArrayList()
    private var recyclerAdapter: Adapter = Adapter(this, resultList)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = recyclerAdapter

        val apiInterface: ApiInterface = ApiClient.getClient()!!.create(ApiInterface::class.java)
        val call: Call<Example?>? = apiInterface.getUsersList()

        call?.enqueue(object : Callback<Example?> {
            override fun onResponse(call: Call<Example?>, response: Response<Example?>) {
                if (response.isSuccessful) {
                    if (response.body() != null) {
                        resultList = response.body()!!.results
                    }
                    recyclerAdapter.setUsersList(resultList)
                }
            }
            override fun onFailure(call: Call<Example?>, t: Throwable) {}
        })
    }
}