package com.example.taskapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.taskapp.databinding.ActivityAddTaskBinding
import com.example.taskapp.databinding.ActivityMainBinding

class AddTaskActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddTaskBinding
    private lateinit var db : TasksDatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAddTaskBinding.inflate(layoutInflater)

        setContentView(binding.root)

        db = TasksDatabaseHelper(this)
        binding.saveButton.setOnClickListener{
            val title = binding.titleEditText.text.toString()
            val content = binding.description.text.toString()
            val task = Task( 0 , title, content)
            db.insertTask(task)
            finish()
            Toast.makeText(this,"Task Added successfully",Toast.LENGTH_SHORT).show()

        }

    }
}