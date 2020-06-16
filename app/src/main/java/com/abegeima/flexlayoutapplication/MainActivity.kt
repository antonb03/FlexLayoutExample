package com.abegeima.flexlayoutapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.abegeima.flexlayoutapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setUpListeners()
    }

    fun setUpListeners(){
        val input = binding.inputLayout.findViewById<EditText>(R.id.input_field)
        binding.addWord.setOnClickListener {
            val bubbleView = LayoutInflater.from(this)
                .inflate(R.layout.bubble_text_view, null) as TextView
            bubbleView.text = input.text.toString()
            bubbleView.setOnClickListener {
                binding.container.removeView(it)
            }
            binding.container.addView(bubbleView)
            input.setText("")
        }
    }
}