package com.emmanuel.retrofit

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.emmanuel.retrofit.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        todoAdapter = TodoAdapter(listOf())


        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service: TodoService = retrofit.create((TodoService::class.java))
        val todos: Call<List<Todo>> = service.getAllTodos()

        todos.enqueue(object : Callback<List<Todo>> {
            override fun onResponse(call: Call<List<Todo>>, response: Response<List<Todo>>) {
                if (response.isSuccessful){
                    response.body()?.let { todos -> }
                    todoAdapter.list = todos
                binding.todosText.text = response.body().toString()
                }
            }

            override fun onFailure(call: Call<List<Todo>>, t: Throwable) {
            }

        })
    }
}