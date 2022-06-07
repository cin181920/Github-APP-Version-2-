package com.example.github

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.github.databinding.ActivitySplashBinding
import java.time.Duration

class Splash : AppCompatActivity() {
    private lateinit var  binding: ActivitySplashBinding

    companion object{
         private const val Duration=1500L
     }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)


        Handler().postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, Duration)


    }
}