package com.example.horasdeproducao

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var consumo: EditText
    lateinit var volume: EditText
    lateinit var seguranca: EditText
    lateinit var vazao: EditText
    lateinit var btnCalcular: Button
    lateinit var resultado: TextView
    lateinit var btnClear: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupView()
        setupListeners()
    }

    fun setupView() {
        consumo = findViewById(R.id.et_consumo_dia)
        volume = findViewById(R.id.et_volume_atual)
        seguranca = findViewById(R.id.et_volume_seguranca)
        vazao = findViewById(R.id.et_vazao_poco)
        btnCalcular = findViewById(R.id.btn_calcular)
        resultado = findViewById(R.id.tv_resultado)
        btnClear = findViewById(R.id.btn_clear)
    }

    fun setupListeners() {
        btnCalcular.setOnClickListener {
            calcular()
        }

        btnClear.setOnClickListener {
            limparDados()
        }
    }

    fun calcular() {
        val consumoStr = consumo.text.toString()
        val volumeStr = volume.text.toString()
        val segurancaStr = seguranca.text.toString()
        val vazaoStr = vazao.text.toString()

        if (consumoStr.isEmpty() || volumeStr.isEmpty() || segurancaStr.isEmpty() || vazaoStr.isEmpty()) {
            resultado.text = "Preencha todos os campos obrigatórios."
            return
        }

        val consumo = consumoStr.toFloat()
        val volume = volumeStr.toFloat()
        val seguranca = segurancaStr.toFloat()
        val vazao = vazaoStr.toFloat()

        // Calcula as horas de produção conforme a fórmula fornecida.
        val result = (consumo - volume + seguranca) / vazao

        resultado.text = result.toString() + " horas"
    }

    fun limparDados() {
        consumo.text.clear()
        volume.text.clear()
        seguranca.text.clear()
        vazao.text.clear()
        resultado.text = ""
    }
}
