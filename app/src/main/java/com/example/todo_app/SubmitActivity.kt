package com.example.todo_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider

class SubmitActivity : AppCompatActivity() {

    private lateinit var viewModel: UserViewModel
    private lateinit var e1 : EditText
    private lateinit var e2 : EditText
    private lateinit var b1 : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_submit)

        e1 = findViewById(R.id.submitText1)
        e2 = findViewById(R.id.submitText2)
        b1 = findViewById(R.id.insertData)

        viewModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(application))
            .get(UserViewModel::class.java)

        b1.setOnClickListener{
            var name :String = e1.text.toString()
            var desig : String = e2.text.toString()
            if(name.isNotEmpty() && desig.isNotEmpty() ){
                viewModel.insertNote(EntityClass(name , desig))
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }

    }
}