package com.example.todo_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() , RclrClicked {

    private lateinit var viewModel: UserViewModel
    private lateinit var rclrView : RecyclerView
    private lateinit var addButton : FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addButton = findViewById(R.id.fab)
        rclrView = findViewById(R.id.rclrView)

        rclrView.layoutManager = LinearLayoutManager(this)
        val adapter = RclrAdapter(this,this)
        rclrView.adapter = adapter

        viewModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(application))
            .get(UserViewModel::class.java)
        viewModel.allNotes.observe(this, Observer {list->

            list?.let {
                adapter.updateList(it)
            }
        })

        addButton.setOnClickListener {
            val intent = Intent(this, SubmitActivity::class.java)
            startActivity(intent)
        }
    }

    override fun itemClicked(notes: EntityClass) {
        viewModel.deleteNote(notes)
    }
}