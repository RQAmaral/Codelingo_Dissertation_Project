package com.example.code_adventure_dissertation

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.*

import androidx.core.content.ContextCompat

class Questions : AppCompatActivity(), OnClickListener {
    private lateinit var tv_question: TextView
    private lateinit var iv_image: ImageView
    private lateinit var progBar: ProgressBar
    private lateinit var tv_progress: TextView
    private lateinit var option_1: TextView
    private lateinit var option_2: TextView
    private lateinit var option_3: TextView
    private lateinit var option_4: TextView
    private lateinit var btn_submit: Button
    private lateinit var unit_title: TextView
    private var mUserName: String? = null
    private var mCurrentPosition: Int = 1
    private var mQuestionsList: ArrayList<Question>? = null
    private var mSelectedOptionsPosition: Int = 0
    private var mCorrectAnswers: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        window.decorView.systemUiVisibility= View.SYSTEM_UI_FLAG_FULLSCREEN
        mUserName = intent.getStringExtra(Constants.USER_NAME)

        unit_title = findViewById<TextView>(R.id.tv_unit)
        unit_title.text = intent.getStringExtra(Constants.UNIT_TITLE)
        option_1 = findViewById(R.id.tv_option_one)
        option_2 = findViewById(R.id.tv_option_two)
        option_3 = findViewById(R.id.tv_option_three)
        option_4 = findViewById(R.id.tv_option_four)
        btn_submit = findViewById(R.id.btn_submit)

        if (intent.getStringExtra(Constants.UNIT_TITLE) == "Tutorial") {
            mQuestionsList = Constants.getQuestions()
        }else if (intent.getStringExtra(Constants.UNIT_TITLE) == "Level 1" ){
            mQuestionsList = Constants.getLvl1Questions()
        }else if (intent.getStringExtra(Constants.UNIT_TITLE) == "Boss Level"){
            mQuestionsList = Constants.getBossLvlQuestions()
        }

        setQuestion()

        option_1.setOnClickListener(this)
        option_2.setOnClickListener(this)
        option_3.setOnClickListener(this)
        option_4.setOnClickListener(this)
        btn_submit.setOnClickListener(this)

    }

    private fun setQuestion(){

        val question = mQuestionsList!![mCurrentPosition-1]

        defaultOptionsView()

        if(mCurrentPosition == mQuestionsList!!.size){
            btn_submit.text = "FINISH!"
        }else{
            btn_submit.text = "SUBMIT"
        }

        tv_question = findViewById(R.id.tv_question)
        iv_image = findViewById<ImageView>(R.id.iv_image)
        tv_progress = findViewById(R.id.tv_progress)
        progBar = findViewById<ProgressBar>(R.id.progress_bar)

        tv_question.text = question!!.question
        iv_image.setImageResource(question.image)
        progBar.progress = mCurrentPosition
        tv_progress.text = "$mCurrentPosition" + "/" + progBar.max

        option_1.text = question.optionOne
        option_2.text = question.optionTwo
        option_3.text = question.optionThree
        option_4.text = question.optionFour
    }

    private fun defaultOptionsView(){
        val options = ArrayList<TextView>()
        options.add(0, option_1)
        options.add(1, option_2)
        options.add(2, option_3)
        options.add(3, option_4)

        for (option in options){
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this, R.drawable.option_button)
        }
    }

    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int){
        defaultOptionsView()
        mSelectedOptionsPosition = selectedOptionNum

        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this, R.drawable.selected_option_button)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.tv_option_one ->{
                selectedOptionView(option_1, 1)
            }
            R.id.tv_option_two ->{
                selectedOptionView(option_2, 2)
            }
            R.id.tv_option_three ->{
                selectedOptionView(option_3, 3)
            }
            R.id.tv_option_four ->{
                selectedOptionView(option_4, 4)
            }
            R.id.btn_submit ->{
                if(mSelectedOptionsPosition == 0){
                    mCurrentPosition++

                    when{
                        mCurrentPosition <= mQuestionsList!!.size ->{
                            setQuestion()
                        }else ->{
                            val intent = Intent(this, Results::class.java)
                            intent.putExtra(Constants.USER_NAME, mUserName)
                            intent.putExtra(Constants.CORRECT_ANSWERS, mCorrectAnswers)
                            intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionsList!!.size)

                            if (intent.getStringExtra(Constants.UNIT_TITLE) == "Tutorial") {
                                val levelComplete = Constants.get_completed_levels()
                                levelComplete.add("Tutorial")
                            }else if (intent.getStringExtra(Constants.UNIT_TITLE) == "Level 1" ){

                            }else if (intent.getStringExtra(Constants.UNIT_TITLE) == "Boss Level"){

                            }

                            startActivity(intent)
                            finish()
                        }
                    }
                }else{
                    val question = mQuestionsList?.get(mCurrentPosition - 1)
                    if(question!!.correctAnswer != mSelectedOptionsPosition){
                        answerView(mSelectedOptionsPosition, R.drawable.incorrect_option_button)
                    }else{
                        mCorrectAnswers++
                    }
                    answerView(question.correctAnswer, R.drawable.correct_option_button)

                    if(mCurrentPosition == mQuestionsList!!.size){
                        btn_submit.text = "FINISH!"
                    }else{

                        btn_submit.text = "NEXT QUESTION"
                    }
                    mSelectedOptionsPosition = 0
                }
            }
        }
    }

    private fun answerView(answer: Int, drawableView: Int){
        when(answer){
            1->{
                option_1.background = ContextCompat.getDrawable(this, drawableView)
            }
            2->{
                option_2.background = ContextCompat.getDrawable(this, drawableView)
            }
            3->{
                option_3.background = ContextCompat.getDrawable(this, drawableView)
            }
            4->{
                option_4.background = ContextCompat.getDrawable(this, drawableView)
            }
        }
    }

}