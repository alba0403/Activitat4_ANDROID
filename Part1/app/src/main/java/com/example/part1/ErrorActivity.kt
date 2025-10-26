package com.example.part1

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ErrorActivity : AppCompatActivity() {

    private lateinit var btnGoBack: Button
    private lateinit var tvUserName: TextView
    private lateinit var tvGuessedNumber: TextView
    private lateinit var tvCorrectNumber: TextView
    private lateinit var tvErrorTitle: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_error)
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
        tvErrorTitle = findViewById(R.id.tvErrorTitle)
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

        tvErrorTitle.text = "Ho sento, $userName!"
        tvGuessedNumber.text = "Has triat el nombre: $guessedNumber"
        tvCorrectNumber.text = "El nombrealba correcte era: $correctNumber"
    }

}