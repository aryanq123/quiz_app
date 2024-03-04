package com.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val etname:EditText=findViewById(R.id.et_name)
        val btnstart:Button=findViewById(R.id.Btn_start)
        btnstart.setOnClickListener {
            if(etname.text.isNotEmpty()){
                val intent=Intent(this,QuizQuestionActivity::class.java)
                intent.putExtra(Constants.User_Name,etname.text.toString())
                startActivity(intent)
                finish()
            }else{
                Toast.makeText(this,"please enter your name",Toast.LENGTH_LONG).show()
            }
        }
    }
}