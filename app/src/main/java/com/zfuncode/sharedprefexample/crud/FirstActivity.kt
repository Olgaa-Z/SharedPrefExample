package com.zfuncode.sharedprefexample.crud

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.zfuncode.sharedprefexample.R
import com.zfuncode.sharedprefexample.databinding.ActivityFirstBinding

class FirstActivity : AppCompatActivity() {
    lateinit var  binding: ActivityFirstBinding
    lateinit var sharedP : SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFirstBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedP = this.getSharedPreferences("first", Context.MODE_PRIVATE)

        binding.btnKirim.setOnClickListener{
            val nama = binding.etNama.text.toString()
            val sPrefs =sharedP.edit()
            sPrefs.putString("NAMA", nama)
            sPrefs.apply()
            startActivity(Intent(this, SecondActivity::class.java))
            finish()
        }


    }
}