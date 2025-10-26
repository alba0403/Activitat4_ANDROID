package com.example.part1

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SuccessActivity : AppCompatActivity() {

    private lateinit var btnGoBack: Button
    private lateinit var tvUserName: TextView
    private lateinit var tvGuessedNumber: TextView
    private lateinit var tvCorrectNumber: TextView
    private lateinit var tvSuccessTitle: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_success)
        initComponent()
        initListeners()
        //aqui dentro ponemos todas las funciones a las que queramos llamar
        initUI()
    }

    private fun initComponent() {
        btnGoBack=findViewById(R.id.btnGoBack)
        tvUserName = findViewById(R.id.tvUserName)
        tvGuessedNumber = findViewById(R.id.tvGuessedNumber)
        tvCorrectNumber = findViewById(R.id.tvCorrectNumber)
        tvSuccessTitle=findViewById(R.id.tvSuccessTitle)
    }

    private fun initListeners() {
        btnGoBack.setOnClickListener { onBackPressed()}
    }

    private fun initUI() {
        showResult()
    }

    private fun showResult() {
        val userName = intent.getStringExtra("USER_NAME") ?: "Usuari"
        val guessedNumber = intent.getIntExtra("GUESSED_NUMBER", 0)
        val correctNumber = intent.getIntExtra("CORRECT_NUMBER", 0)

        tvSuccessTitle.text = "Enhorabona, $userName!"

        tvGuessedNumber.text = "Has triat el nombre: $guessedNumber"
        tvCorrectNumber.text = "El nombre correcte era: $correctNumber"
    }


}