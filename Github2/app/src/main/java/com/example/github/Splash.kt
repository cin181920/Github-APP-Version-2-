package com.example.github

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ViewPropertyAnimator
import android.widget.ImageView
import androidx.appcompat.app.AppCompatDelegate
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.ViewModelProvider


val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")
@SuppressLint("CustomSplashScreen")
class Splash : AppCompatActivity() {

    private var animation: ViewPropertyAnimator? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        supportActionBar?.hide()
        val image = findViewById<ImageView>(R.id.github_logo)

        val pref = SettingPreferences.getInstance(dataStore)
        val appViewModel = ViewModelProvider(this, ViewModelFactory(pref)).get(
            SettingViewModel::class.java
        )

        image.alpha = 0f

        animation = image.animate().setDuration(2_000L).alpha(1f).withEndAction {
            Intent(this, MainActivity::class.java).apply {
                startActivity(this)
                finish()
            }
        }

        appViewModel.getThemeSettings().observe(this, { state ->
            Log.d("Splash", "$state")

            val mode = if (state) AppCompatDelegate.MODE_NIGHT_YES
            else AppCompatDelegate.MODE_NIGHT_NO

            AppCompatDelegate.setDefaultNightMode(mode)

            animation?.start()
        })
    }

    override fun onDestroy() {
        animation?.cancel()
        super.onDestroy()
    }


}