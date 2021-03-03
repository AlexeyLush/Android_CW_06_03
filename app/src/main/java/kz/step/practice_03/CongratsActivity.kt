package kz.step.practice_03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.widget.TextView

class CongratsActivity : AppCompatActivity() {

    var textViewResult: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_congrats2)
        initializeViews()
    }

    fun initializeViews(){
        textViewResult = findViewById(R.id.textview_result)
        val message = intent.getStringExtra(EXTRA_MESSAGE)
        textViewResult?.text = "Вы правильно ответили на $message вопросов"
    }

}