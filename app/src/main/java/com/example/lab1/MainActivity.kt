package com.example.lab1

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    private var button: Button? = null
    private var radioButtonYes: RadioButton? = null
    private var radioButtonNo: RadioButton? = null
    private var inputQuestion: TextInputEditText? = null
    private var output: TextView? = null

    private lateinit var answer: String
    private lateinit var question: String

    private lateinit var text: String
    private lateinit var toast: Toast
    private  var duration: Int = Toast.LENGTH_SHORT

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        button = findViewById(R.id.buttonOk)
        radioButtonYes = findViewById(R.id.buttonYes)
        radioButtonNo = findViewById(R.id.buttonNo)
        inputQuestion = findViewById(R.id.inputQuestion)
        output = findViewById(R.id.output)

        button?.setOnClickListener {
            if (inputQuestion?.text.toString() != "") {
                if (radioButtonYes?.isChecked == true || radioButtonNo?.isChecked == true){
                    question = inputQuestion?.text.toString()
                    output?.text = "$question\nВідповідь: $answer"
                }
                else{
                    text = "Ви не обрали відповідь!!!"
                    toast = Toast.makeText(applicationContext, text, duration)
                    toast.show()
                }
            }
            else{
                text = "Ви не ввели питання!!!"
                toast = Toast.makeText(applicationContext, text, duration)
                toast.show()
            }
        }

        radioButtonYes?.setOnClickListener {
            answer = "Так"
            radioButtonNo?.isChecked = false
        }

        radioButtonNo?.setOnClickListener {
            answer = "Ні"
            radioButtonYes?.isChecked = false
        }
    }
}