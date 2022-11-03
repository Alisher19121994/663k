package com.example.a663k

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.example.a663k.models.Employee
import com.example.a663k.retrofit.PosterResponse
import com.example.a663k.retrofit.PosterService
import com.example.a663k.retrofit.RetrofitHttp
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    var TAG = MainActivity::class.java.simpleName
    lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        initViews()
    }

    private fun initViews() {

        val employee = Employee(0, "Alisher", 500, 27, "")
        val employeePOST = Employee(0, "Alisherbek", 88800, 27, "")
        val employeePUT = Employee(0, "Alisher Daminov", 50000, 27, "")

        apiList()
        //apiSingle()
        //apiPost()
        //apiPut()
        //apiDelete()
    }

    private fun apiList() {
        RetrofitHttp.posterService.getListPost()
            .enqueue(object : Callback<ArrayList<PosterResponse>> {
                override fun onResponse(
                    call: Call<ArrayList<PosterResponse>>,
                    response: Response<ArrayList<PosterResponse>>
                ) {

                    Log.d(TAG, response.toString())
                }

                override fun onFailure(call: Call<ArrayList<PosterResponse>>, t: Throwable) {
                    t.message?.let { Log.d(TAG, it) }
                }

            })
    }

    private fun apiSingle(employee: Employee) {

        RetrofitHttp.posterService.singleListPost(employee.id)
            .enqueue(object : Callback<PosterResponse> {
                override fun onResponse(
                    call: Call<PosterResponse>,
                    response: Response<PosterResponse>
                ) {
                    Log.d(TAG, response.toString())
                }

                override fun onFailure(call: Call<PosterResponse>, t: Throwable) {
                    t.message?.let { Log.d(TAG, it) }
                }

            }

            )
    }

    private fun apiPost(employee: Employee) {

        RetrofitHttp.posterService.postListPost(employee)
            .enqueue(object : Callback<PosterResponse> {
                override fun onResponse(
                    call: Call<PosterResponse>,
                    response: Response<PosterResponse>
                ) {
                    Log.d(TAG, response.toString())
                }

                override fun onFailure(call: Call<PosterResponse>, t: Throwable) {
                    t.message?.let { Log.d(TAG, it) }
                }

            })
    }

    private fun apiPut(employee: Employee) {
        RetrofitHttp.posterService.putListPost(employee.id, employee)
            .enqueue(object : Callback<PosterResponse> {
                override fun onResponse(
                    call: Call<PosterResponse>,
                    response: Response<PosterResponse>
                ) {
                    Log.d(TAG, response.toString())

                }

                override fun onFailure(call: Call<PosterResponse>, t: Throwable) {
                    t.message?.let { Log.d(TAG, it) }
                }

            })
    }

    private fun apiDelete(employee: Employee) {
        RetrofitHttp.posterService.deleteListPost(employee.id)
            .enqueue(object : Callback<PosterResponse> {
                override fun onResponse(
                    call: Call<PosterResponse>,
                    response: Response<PosterResponse>
                ) {
                    Log.d(TAG, response.toString())
                }

                override fun onFailure(call: Call<PosterResponse>, t: Throwable) {
                    t.message?.let { Log.d(TAG, it) }
                }

            })
    }
}