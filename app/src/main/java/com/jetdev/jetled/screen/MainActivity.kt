package com.jetdev.jetled.screen

import android.R
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.jetdev.jetled.databinding.ActivityMainBinding
import com.skydoves.colorpickerview.ColorEnvelope
import com.skydoves.colorpickerview.ColorPickerDialog
import com.skydoves.colorpickerview.listeners.ColorEnvelopeListener
import org.koin.android.ext.android.inject


class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by inject()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button1.setOnClickListener {
            viewModel.jetDevFill()
        }
        binding.button2.setOnClickListener {
            viewModel.animateWalking()
        }
        binding.button3.setOnClickListener {
            viewModel.animateWalkingFilled()
        }
        binding.button4.setOnClickListener {
            viewModel.animateFull()
        }
        binding.button5.setOnClickListener {
            viewModel.animFlagFrHorizontal()
        }
        binding.button6.setOnClickListener {
            viewModel.animFlagFrVertical()
        }
        binding.button7.setOnClickListener {
            viewModel.animFlagBe()
        }
        binding.button8.setOnClickListener {
            viewModel.animFlagIt()
        }
        binding.button9.setOnClickListener {
            viewModel.reset()
        }

        binding.buttonColorPalette.setOnClickListener {
            val dialog = ColorPickerDialog.Builder(this)
                .setTitle("ColorPicker Dialog")
                .setPreferenceName("MyColorPickerDialog")
                .setPositiveButton("OK",
                    ColorEnvelopeListener { envelope, fromUser -> toastColor(envelope) })
                .setNegativeButton(
                    getString(R.string.cancel)
                ) { dialogInterface, i -> dialogInterface.dismiss() }
                .attachAlphaSlideBar(true) // the default value is true.
                .attachBrightnessSlideBar(true) // the default value is true.
                .setBottomSpace(12) // set a bottom space between the last slidebar and buttons.
            dialog.show()
        }
        viewModel.isAlive.observe(this) {
            if (it) {
                Toast.makeText(
                    this,
                    "on dirait que le monstre est vivant \uD83D\uDC4D",
                    Toast.LENGTH_SHORT
                )
                    .show()
            } else {
                Toast.makeText(this, "pas de réponse du serveur \uD83D\uDC4E", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    fun toastColor(color: ColorEnvelope) {
        Toast.makeText(this, "${color.hexCode.toString()}", Toast.LENGTH_SHORT).show()
    }
}