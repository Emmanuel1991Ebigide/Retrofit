package com.emmanuel.retrofit

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.emmanuel.retrofit.databinding.TodoItemBinding

 class TodoAdapter(val list: List<Todo>): RecyclerView.Adapter<> {

    class TodoViewHolder(binding: TodoItemBinding): RecyclerView.ViewHolder(binding.root)

     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
         val binding = TodoItemBinding.inflate(la.from(parent.context)
             return TodoViewHolder(binding)
     }

     override fun onBindViewHolder(holder: ???, position: Int) {
         fun bind(todo: Todo){
             binding.textView.text = todo.title
             if (todo.completed){
                 binding.imageView.visibility = View.VISIBLE
             }
             else{
                 binding.imageView.visibility = View.INVISIBLE
             }
         }
     }

     override fun getItemCount(): Int {
         TODO("Not yet implemented")
     }

 }