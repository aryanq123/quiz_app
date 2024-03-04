package com.quizapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tvName:TextView=findViewById(R.id.tv_name)
        val tvScore:TextView=findViewById(R.id.tv_score)
        val btnFinish:Button=findViewById(R.id.btn_finish)
        tvName.text=intent.getStringExtra(Constants.User_Name)
        val totalQuestions=intent.getStringExtra(Constants.Total_Questions)
        val correctAnswer=intent.getStringExtra(Constants.Correct_Answer)
        tvScore.text="Your score is $correctAnswer out of $totalQuestions"
        btnFinish.setOnClickListener {

            startActivity(Intent(this,MainActivity::class.java))
        }
    }
}