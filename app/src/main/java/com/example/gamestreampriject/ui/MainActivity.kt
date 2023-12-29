package com.example.gamestreampriject.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gamestreampriject.R
import com.example.gamestreampriject.databinding.ActivityMainBinding
import com.example.gamestreampriject.ui.main.MainFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if(savedInstanceState == null){
            supportFragmentManager.beginTransaction()
                .add(R.id.container, MainFragment())
                .commitAllowingStateLoss()
        }
    }
}