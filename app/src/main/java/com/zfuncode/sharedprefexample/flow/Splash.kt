package com.zfuncode.sharedprefexample.flow

import android.content.Context
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import com.zfuncode.sharedprefexample.R
import com.zfuncode.sharedprefexample.databinding.FragmentSplash2Binding

class Splash : Fragment() {

lateinit var binding : FragmentSplash2Binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSplash2Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Handler().postDelayed({
            if (context?.getSharedPreferences("dataregist" , Context.MODE_PRIVATE)!!.contains("username")){
                Navigation.findNavController(view).navigate(R.id.action_splash_to_homeFragment)

            }else{
                Navigation.findNavController(view).navigate(R.id.action_splash_to_loginFragment)

            }

        }, 2000)



    }

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity).supportActionBar?.hide()
    }

    override fun onStop() {
        super.onStop()
        (activity as AppCompatActivity).supportActionBar?.show()
    }


}