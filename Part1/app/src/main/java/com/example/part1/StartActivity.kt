package com.example.part1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class StartActivity : AppCompatActivity() {
    //inicialización de las variable de los componentes
    private lateinit var tvHelloName: TextView
    private lateinit var etNumber: EditText
    private lateinit var btnSolution: Button
    private lateinit var btnGoBack: Button

    // variables per la lògica
    private var correctNumber = 0
    private var userName = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
        initComponent()
        initListeners()
        //aqui dentro ponemos todas las funciones a las que queramos llamar
        initUI()
    }

    private fun initComponent() {
        tvHelloName=findViewById(R.id.tvHelloName)
        etNumber = findViewById(R.id.etNumber)
        btnSolution = findViewById(R.id.btnSolution)
        btnGoBack=findViewById(R.id.btnGoBack)
    }

    private fun initListeners() {
        btnSolution.setOnClickListener {
            val guessedNumber = etNumber.text.toString().trim().toIntOrNull()

            if (guessedNumber == null || guessedNumber !in 1..3) {
                etNumber.error = "Introduce un número entre 1 y 3"
            } else {
                // Comparar número introducido con el correcto y pasar datos
                val nextIntent = if (guessedNumber == correctNumber) {
                    Intent(this, SuccessActivity::class.java)
                } else {
                    Intent(this, ErrorActivity::class.java)
                }

                nextIntent.putExtra("USER_NAME", userName)
                nextIntent.putExtra("GUESSED_NUMBER", guessedNumber)
                nextIntent.putExtra("CORRECT_NUMBER", correctNumber)

                startActivity(nextIntent) // muy importante
            }
        }

        btnGoBack.setOnClickListener { onBackPressed()}


    }
        private fun initUI() {
            showName()
            numGeneration()
        }


    private fun showName() {
            userName = intent.getStringExtra("USER_NAME") ?: "Usuari"
            tvHelloName.text = "Hola, $userName"

        }

        private fun numGeneration() {
            correctNumber = Random.nextInt(1, 4)
        }
    }