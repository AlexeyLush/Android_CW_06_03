package kz.step.practice_03

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.widget.Button
import android.widget.TextView
import kz.step.practice_03.Models.Question

class MainActivity : AppCompatActivity() {

    var questions: List<Question?>? = null

    var btnAnswerFirst: Button? = null
    var btnAnswerSecond: Button? = null
    var btnAnswerThird: Button? = null
    var btnAnswerFourth: Button? = null

    var listButton: List<Button?>? = null

    var textViewQuestion: TextView? = null
    var textViewResult: TextView? = null

    var goodAnswer: Int = 0
    var currentQuestion: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeViews()
        initializeQuestions()


        initializeButtons()
        initializeCurrentQuestion()
        initializeListeners()


    }

    fun initializeViews(){

        btnAnswerFirst = findViewById(R.id.btn_answer_1)
        btnAnswerSecond = findViewById(R.id.btn_answer_2)
        btnAnswerThird = findViewById(R.id.btn_answer_3)
        btnAnswerFourth = findViewById(R.id.btn_answer_4)



        textViewQuestion = findViewById(R.id.textview_question)
        textViewResult = findViewById(R.id.textview_result)

        textViewResult?.text = "Вы ответили правильно на $goodAnswer вопросов"

    }

    fun initializeQuestions(){
        questions = arrayListOf(Question("В каком городе не работал великий композитор 18-го века Кристоф Виллибальд Глюк?", arrayListOf("Милан","Берлин", "Вена","Париж"), 1),
            Question("Кто первым доказал периодичность появления комет?", arrayListOf("Галилей","Коперник", "Галлей","Кеплер"), 2))
    }

    fun initializeButtons(){
        listButton = arrayListOf(btnAnswerFirst, btnAnswerSecond, btnAnswerThird, btnAnswerFourth)
    }

    fun initializeCurrentQuestion(){
        var question: Question? = questions?.get(currentQuestion)

        textViewQuestion?.text = question?.question

        for (i in 0..3){
            listButton?.get(i)?.text = question?.answers?.get(i)
        }

    }

    fun initializeListeners(){

        var question: Question? = questions?.get(currentQuestion)
        var index: Int? = question?.indexTrueAnswer

        for (button in listButton!!){
            button?.setOnClickListener{
                if (question?.answers?.get(index!!) == button.text){
                    goodAnswer++
                    textViewResult?.text = "Вы ответили правильно на $goodAnswer вопросов"
                }
                currentQuestion++
                if (currentQuestion < questions?.size!!){
                    initializeCurrentQuestion()
                    initializeListeners()
                }
                else{
                    var intent: Intent = Intent(this, CongratsActivity::class.java).apply {
                        putExtra(EXTRA_MESSAGE, goodAnswer.toString())
                    }
                    startActivity(intent)
                }
            }
        }
    }


}

