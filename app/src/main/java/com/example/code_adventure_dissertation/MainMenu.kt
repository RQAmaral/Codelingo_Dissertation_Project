package com.example.code_adventure_dissertation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.core.content.ContextCompat

class MainMenu : AppCompatActivity() {

    private lateinit var tutorialButton: ImageButton
    private lateinit var firstlvlButton: ImageButton
    private lateinit var bosslvlButton: ImageButton
    private var mUserName: String? = null
    private var completedLevels: ArrayList<String> = Constants.get_completed_levels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)

        window.decorView.systemUiVisibility= View.SYSTEM_UI_FLAG_FULLSCREEN
        mUserName = intent.getStringExtra(Constants.USER_NAME)

        tutorialButton = findViewById<ImageButton>(R.id.btn_tutorial_level)
        firstlvlButton = findViewById<ImageButton>(R.id.btn_level1)
        bosslvlButton = findViewById<ImageButton>(R.id.btn_boss_level)

        for (level in completedLevels){
            if (level == "Tutorial"){
                tutorialButton.setBackgroundColor(R.drawable.level_incomplete_menu_icon);
            }
        }

        tutorialButton.setOnClickListener{
                val intent = Intent(this,Questions::class.java)
                intent.putExtra(Constants.UNIT_TITLE,"Tutorial")
                intent.putExtra(Constants.USER_NAME, mUserName)
                startActivity(intent)
                finish()
            }
        firstlvlButton.setOnClickListener{
                val intent = Intent(this,Questions::class.java)
                intent.putExtra(Constants.UNIT_TITLE,"Level 1")
                intent.putExtra(Constants.USER_NAME, mUserName)
                startActivity(intent)
                finish()
            }
        bosslvlButton.setOnClickListener{
                val intent = Intent(this,Questions::class.java)
                intent.putExtra(Constants.UNIT_TITLE,"Boss Level")
                intent.putExtra(Constants.USER_NAME, mUserName)
                startActivity(intent)
                finish()
            }
        }
    }