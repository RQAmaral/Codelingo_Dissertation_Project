package com.example.code_adventure_dissertation

object Constants{

    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_questions"
    const val CORRECT_ANSWERS: String = "correct_answers"
    const val UNIT_TITLE: String = "current unit"
    private val COMPLETED_LEVELS: ArrayList<String> = ArrayList<String>()

    fun get_completed_levels() : ArrayList<String>{
        return COMPLETED_LEVELS
    }

    fun getQuestions(): ArrayList<Question>{
        val questionsList = ArrayList<Question>()

        val q1 = Question(
            1,
            "What is Javascript?",
            R.drawable.background,
            "It is a scripting language used to make the website interactive",
            "It is an assembly language used to make the website interactive",
            "It is a compiled language used to make the website interactive",
            "None of the mentioned",
            1
        )

        val q2 = Question(
            2,
            "Javascript is an _______ language?",
            R.drawable.background,
            "Object-Oriented",
            "Object-Based",
            "Procedural",
            "None of the mentioned",
            1
        )

        val q3 = Question(
            3,
            "Which of the following keywords is used to define a variable in Javascript?",
            R.drawable.background,
            "var",
            "let",
            "Both of the above",
            "None of the mentioned",
            1
        )

        questionsList.add(q1)
        questionsList.add(q2)
        questionsList.add(q3)
        return questionsList
    }
    fun getLvl1Questions(): ArrayList<Question>{
        val questionsList = ArrayList<Question>()

        val q1 = Question(
            1,
            "Inside which HTML element do we put JavaScript code?",
            R.drawable.background,
            "<javascript>",
            "<scripting>",
            "<js>",
            "<script>",
            4
        )

        val q2 = Question(
            2,
            "What is the correct JavaScript syntax to change the content of the HTML element below?\n" +
                    "\n" +
                    "<p id=\"demo\">This is a demonstration.</p>",
            R.drawable.background,
            "#demo.innerHTML = \"Hello World!\";",
            "document.getElementByName(\"p\").innerHTML = \"Hello World!\";",
            "document.getElementById(\"demo\").innerHTML = \"Hello World!\";",
            "document.getElement(\"p\").innerHTML = \"Hello World!\";",
            3
        )

        val q3 = Question(
            3,
            "Where is the correct place to insert a JavaScript?",
            R.drawable.background,
            "The <head> section",
            "Both the <head> section and the <body> section are correct",
            "The <body> section",
            "None of the mentioned",
            2
        )

        questionsList.add(q1)
        questionsList.add(q2)
        questionsList.add(q3)
        return questionsList
    }
    fun getBossLvlQuestions(): ArrayList<Question>{
        val questionsList = ArrayList<Question>()

        val q1 = Question(
            1,
            "What is Javascript?",
            R.drawable.background,
            "It is an assembly language used to make the website interactive",
            "It is a scripting language used to make the website interactive",
            "It is a compiled language used to make the website interactive",
            "None of the mentioned",
            2
        )

        val q2 = Question(
            2,
            "What is the correct JavaScript syntax to change the content of the HTML element below?\n" +
                    "<p id=\"demo\">This is a demonstration.</p>",
            R.drawable.background,
            "document.getElementById(\"demo\").innerHTML = \"Hello World!\";",
            "document.getElementByName(\"p\").innerHTML = \"Hello World!\";",
            "#demo.innerHTML = \"Hello World!\";",
            "document.getElement(\"p\").innerHTML = \"Hello World!\";",
            1
        )

        val q3 = Question(
            3,
            "Javascript is an _______ language?",
            R.drawable.background,
            "Object-Based",
            "Object-Oriented",
            "Procedural",
            "None of the mentioned",
            2
        )

        val q4 = Question(
            4,
            "Inside which HTML element do we put JavaScript code?",
            R.drawable.background,
            "<js>",
            "<javascript>",
            "<script>",
            "<scripting>",
            3
        )

        val q5 = Question(
            5,
            "Which of the following keywords is used to define a variable in Javascript?",
            R.drawable.background,
            "var",
            "let",
            "Both of the above",
            "None of the mentioned",
            1
        )

        val q6 = Question(
            6,
            "Where is the correct place to insert a JavaScript?",
            R.drawable.background,
            "The <head> section",
            "The <body> section",
            "Both of the above",
            "None of the mentioned",
            3
        )

        val q7 = Question(
            7,
            "How to write an IF statement in JavaScript?",
            R.drawable.background,
            "if i == 5 then",
            "if i = 5 then",
            "if i = 5",
            "if (i == 5) ",
            4
        )

        questionsList.add(q1)
        questionsList.add(q2)
        questionsList.add(q3)
        questionsList.add(q4)
        questionsList.add(q5)
        questionsList.add(q6)
        questionsList.add(q7)
        return questionsList
    }
}