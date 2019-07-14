package com.anda.mjk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Toast
import com.anda.mjk.dto.PlantDTO
import com.anda.mjk.dto.PlantList
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getplantlists();

    }

    fun getplantlists(){

        val service = RetrofitClientInstance.retrofitInstance?.create(GetPlantServices::class.java)
        val  call=service?.getallplants()
        call?.enqueue(object: Callback<PlantList>{
            override fun onFailure(call: Call<PlantList>, t: Throwable) {

                Toast.makeText(applicationContext,"Response Failed",Toast.LENGTH_SHORT).show()

            }

            override fun onResponse(call: Call<PlantList>, response: Response<PlantList>) {

                Toast.makeText(applicationContext,"Response Sucessful",Toast.LENGTH_SHORT).show()
                val body =response?.body()
                val plant =body?.plants
                val size=plant?.size
                Log.d("Test",plant.toString())
                val adapter = ArrayAdapter<PlantDTO>(applicationContext,android.R.layout.simple_spinner_dropdown_item,plant)
                autotextview_.setAdapter(adapter)

            }


        })












    }
}
