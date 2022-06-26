package com.jetdev.jetled.screen

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.jetdev.jetled.databinding.ActivityMainBinding
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by inject()
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button1.setOnClickListener {
            Toast.makeText(this, "Tu t'attendais à quoi?", Toast.LENGTH_SHORT).show()
        }
        binding.button2.setOnClickListener {
            viewModel.animateWalking()
        }
        binding.button3.setOnClickListener {
            viewModel.ping()
        }
        viewModel.isAlive.observe(this) {
            if (it) {
                Toast.makeText(this, "on dirait que le monstre est vivant \uD83D\uDC4D", Toast.LENGTH_SHORT)
                    .show()
            } else {
                Toast.makeText(this, "pas de réponse du serveur \uD83D\uDC4E", Toast.LENGTH_SHORT).show()
            }
        }
    }
}