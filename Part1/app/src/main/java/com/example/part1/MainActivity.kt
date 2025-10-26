package com.example.part1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class MainActivity : AppCompatActivity() {
    //inicialización de las variable de los componentes
    private lateinit var btnStart: Button
    private lateinit var tvDate: TextView
    private lateinit var etUserName: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initComponent()
        initListeners()
        //aqui dentro ponemos todas las funciones a las que queramos llamar
        initUI()

    }

    private fun initComponent() {
        btnStart=findViewById(R.id.btnStart)
        tvDate=findViewById(R.id.tvDate)
        etUserName=findViewById(R.id.etUserName)
    }

    private fun initListeners() {
        btnStart.setOnClickListener {
            val userName = etUserName.text.toString()
            if (userName.isEmpty()) {
                // Si no han ficat el nom d'usuari salta un avis i no deixa iniciar
                etUserName.error = "Siusplau, introdueix el teu nom"
            } else {
                // Si hi ha nom, va a StartActivity
                val intent = Intent(this, StartActivity::class.java)
                intent.putExtra("USER_NAME", userName) // añadir este extra
                startActivity(intent)
            }
        }


    }
    // funció per calcular la data
    private fun dateCalcul(){
        val currentDate = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(Date())
        tvDate.text = "Data actual: $currentDate"
    }

    private fun initUI() {
        dateCalcul()
    }
}