package com.example.recyclerviewpractice1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        var todoList = mutableListOf(
            ToDo("Do homework", false),
            ToDo("Take a shower", false),
            ToDo("feed my cat", true)
        )

        val adapter  = ToDoAdapter(todoList)
        rvToDo.adapter = adapter
        rvToDo.layoutManager = LinearLayoutManager(this)


     
        btnToDo.setOnClickListener {

            val title = etTodo.text.toString()
            val todo = ToDo(title, false)
            todoList.add(todo)

            adapter.notifyItemInserted(todoList.size -1  )
        }
    }
}