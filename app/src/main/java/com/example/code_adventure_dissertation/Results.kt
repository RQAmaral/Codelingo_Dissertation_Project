package com.example.code_adventure_dissertation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class Results : AppCompatActivity() {

    private lateinit var tv_name: TextView
    private lateinit var tv_score: TextView
    private lateinit var btn_finish: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_results)

        window.decorView.systemUiVisibility= View.SYSTEM_UI_FLAG_FULLSCREEN

        val userName = intent.getStringExtra(Constants.USER_NAME)
        val correctAnswers = intent.getIntExtra(Constants.CORRECT_ANSWERS, 0)
        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)

        tv_name = findViewById(R.id.tv_name)
        tv_name.text = "Well done, $userName!"

        tv_score = findViewById(R.id.tv_score)
        tv_score.text = "$correctAnswers/$totalQuestions"

        btn_finish = findViewById(R.id.btn_next)
        btn_finish.setOnClickListener{
            val intent = Intent(this, MainMenu::class.java)
            intent.putExtra(Constants.USER_NAME, userName)
            startActivity(intent)
            finish()
        }

    }
} 