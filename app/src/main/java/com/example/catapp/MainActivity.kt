package com.example.catapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.catapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Initialize the View Binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Condition to check and add fragment only if savedInstanceState is null
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, CatFactsFragment())
                .commit()
        }
    }
}

