package com.zfuncode.sharedprefexample.crud

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.zfuncode.sharedprefexample.R
import com.zfuncode.sharedprefexample.databinding.ActivityInputDataBinding

class InputDataActivity : AppCompatActivity() {

    lateinit var binding : ActivityInputDataBinding
    lateinit var sharedPrefs :SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityInputDataBinding.inflate(layoutInflater)
        setContentView(binding.root)


        sharedPrefs =this.getSharedPreferences("sf", Context.MODE_PRIVATE)

        binding.btnsave.setOnClickListener{
            var nim = binding.etNim.text.toString()
            var name = binding.etName.text.toString()

            var addData =sharedPrefs.edit()
            addData.putString("nim", nim)
            addData.putString("name", name)
            addData.apply()
            Toast.makeText(this, "Data Saved", Toast.LENGTH_SHORT).show()
        }

        binding.btnView.setOnClickListener{
            val getNim = sharedPrefs.getString("nim", "12345")
            val getName = sharedPrefs.getString("name", "default")
            binding.tvNim.text = getNim
            binding.tvName.text = getName
        }

        binding.btnClear.setOnClickListener{
            var delSharedPref = sharedPrefs.edit()
            delSharedPref.clear()
            delSharedPref.apply()
            binding.tvNim.text = ""
            binding.tvName.setText("")
            Toast.makeText(this, "Data has been deleted", Toast.LENGTH_SHORT).show()
        }

    }

}