package com.zfuncode.sharedprefexample.crud

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.zfuncode.sharedprefexample.R
import com.zfuncode.sharedprefexample.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var data = this.getSharedPreferences("first", Context.MODE_PRIVATE)
        var nama =data.getString("NAMA","")

        binding.getName.text = nama


    }
}