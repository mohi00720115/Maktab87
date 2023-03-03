package com.example.quizandroid.activity1.login

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.viewModels
import com.example.quizandroid.R
import com.example.quizandroid.activity1.signUp.SignUpFragment
import com.example.quizandroid.activity2.TaskActivity
import com.example.quizandroid.databinding.FragmentLoginBinding
import com.google.android.material.snackbar.Snackbar

class LoginFragment : Fragment(R.layout.fragment_login) {
    private lateinit var binding: FragmentLoginBinding
    private val vmLogin: LoginViewModel by viewModels()
//    lateinit var sharedPref : SharedPreferences

    companion object {
        const val KEY_NAME_LOGIN = "KEY_NAME_LOGIN"
        const val KEY_PASS_LOGIN = "KEY_PASS_LOGIN"
        const val KEY_NAME_SIGNUP = "KEY_NAME_SIGNUP"
        const val KEY_PASS_SIGNUP = "KEY_PASS_SIGNUP"
    }

    @SuppressLint("CommitPrefEdits")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DataBindingUtil.bind(view)!!          //باید بنویسیش
        binding.lifecycleOwner = this                   //باید بنویسیش
        binding.viewModelLogin = vmLogin                //باید بنویسیش

//        sharedPref.edit().apply{
//            arguments?.getString(KEY_NAME_LOGIN)
//            arguments?.getString(KEY_PASS_LOGIN)
//            arguments?.getString(KEY_NAME_SIGNUP)
//            arguments?.getString(KEY_PASS_SIGNUP)
//        }

        if (arguments?.getString(KEY_NAME_SIGNUP) != null &&
            arguments?.getString(KEY_PASS_SIGNUP) != null
        ) {
            vmLogin.name.value = arguments?.getString(KEY_NAME_SIGNUP).toString()
            vmLogin.pass.value = requireArguments().getString(KEY_PASS_SIGNUP).toString()
        }

        binding.btnLogin.setOnClickListener {
            if (binding.editTextUserName.text.toString() == "" || binding.editTextPassword.text.toString() == "") {
                Snackbar.make(view, "کادر خالیه", Snackbar.LENGTH_SHORT).show()
//                Toast.makeText(requireContext(), "کادر خالیه", Toast.LENGTH_SHORT).show()
            } else {
                if (binding.editTextUserName.text.toString() == arguments?.getString(KEY_NAME_SIGNUP) &&
                    binding.editTextPassword.text.toString() == arguments?.getString(KEY_PASS_SIGNUP)
                ) {
                    Snackbar.make(view, "برابره", Snackbar.LENGTH_SHORT).show()
//                    Toast.makeText(requireContext(), "برابره", Toast.LENGTH_SHORT).show()
                } else Snackbar.make(view, "نا برابره", Snackbar.LENGTH_SHORT).show()
            }
        }

        binding.btnSingUp.setOnClickListener {
            val userName = binding.editTextUserName.text.toString()
            val passWord = binding.editTextPassword.text.toString()
            val bundle = bundleOf(KEY_NAME_LOGIN to userName, KEY_PASS_LOGIN to passWord)

            if (binding.editTextUserName.text.toString() == arguments?.getString(KEY_NAME_SIGNUP)
                    .toString() &&
                binding.editTextPassword.text.toString() == arguments?.getString(KEY_PASS_SIGNUP)
                    .toString()
            ) {
                val intent = Intent(requireContext(), TaskActivity::class.java)
                startActivity(intent)
            } else {
                parentFragmentManager.commit {
                    setReorderingAllowed(true)
                    add<SignUpFragment>(R.id.container_view, args = bundle)
                    addToBackStack(null)
                }
            }


        }


    }
}
