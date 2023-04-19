package com.example.code_adventure_dissertation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var startbutton: Button
    private lateinit var playerName: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.decorView.systemUiVisibility= View.SYSTEM_UI_FLAG_FULLSCREEN

        startbutton = findViewById<Button>(R.id.btn_start)
        playerName = findViewById<TextView>(R.id.editTextTextPersonName)

        startbutton.setOnClickListener{
            if(playerName.text.toString().isEmpty()){
                Toast.makeText(this,"Please enter a name", Toast.LENGTH_SHORT).show()

            }else{
               val intent = Intent(this,MainMenu::class.java)
                intent.putExtra(Constants.USER_NAME,playerName.text.toString())
                startActivity(intent)
                finish()
            }
        }
    }
}