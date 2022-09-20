package com.zfuncode.sharedprefexample.flow

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.zfuncode.sharedprefexample.R
import com.zfuncode.sharedprefexample.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {

    lateinit var binding : FragmentLoginBinding
    lateinit var dataPref : SharedPreferences
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvRegister.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_registFrag)
        }

        dataPref = requireContext().getSharedPreferences("dataregist", Context.MODE_PRIVATE)
        doLogin()

//        var ff = requireContext().getSharedPreferences("dataregist", Context.MODE_PRIVATE)
//        var da = ff.getString("username", "")
//        Toast.makeText(context, "$da", Toast.LENGTH_SHORT).show()

    }

    fun  doLogin(){
        binding.btnLogin.setOnClickListener(){
            var getUsername =dataPref.getString("username","")
            var getPass = dataPref.getString("password", "")

            var usr = binding.etUsername.text.toString()
            var pass = binding.etPassword.text.toString()

            if (usr == getUsername && pass.equals(getPass)){
                Navigation.findNavController(requireView()).navigate(R.id.action_loginFragment_to_homeFragment)
            }else{
                Toast.makeText(context, "Login Failed", Toast.LENGTH_SHORT).show()
            }
        }

    }


}