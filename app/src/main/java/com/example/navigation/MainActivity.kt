package com.example.navigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.navigation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            // в этот момент мы показываем Fragment со списком городов
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container_view, FirstFragment())
                .commit()
        }
    }
}