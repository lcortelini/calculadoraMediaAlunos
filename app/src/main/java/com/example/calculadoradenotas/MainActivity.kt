package com.example.calculadoradenotas

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.EditorInfo.IME_ACTION_DONE
import com.example.calculadoradenotas.R.color.specialgreen
import com.example.calculadoradenotas.R.color.specialred
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val specialGreen = getResources().getColor(R.color.specialgreen)
        val specialRed = getResources().getColor(R.color.specialred)

        val btCalcular = calcular
        val resultado = resultado

        btCalcular.setOnClickListener {

            val nota1 = Integer.parseInt(nota1.text.toString())
            val nota2 = Integer.parseInt(nota2.text.toString())
            val media = (nota1 + nota2) / 2
            val faltas = Integer.parseInt(faltas.text.toString())

            if(media >= 6 && faltas<= 10) {
                resultado.setText("Aluno foi aprovado! \n Nota final: $media \n Faltas: $faltas")
                resultado.onEditorAction(IME_ACTION_DONE)
                resultado.setTextColor(specialGreen)
            } else {
                resultado.setText("Aluno foi reprovado! \n Nota final: $media \n Faltas: $faltas")
                resultado.onEditorAction(IME_ACTION_DONE)
                resultado.setTextColor(specialRed)
            }

        }
    }
}