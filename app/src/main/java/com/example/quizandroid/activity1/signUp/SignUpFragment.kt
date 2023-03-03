package com.example.quizandroid.activity1.signUp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.fragment.app.viewModels
import com.example.quizandroid.R
import com.example.quizandroid.activity1.login.LoginFragment
import com.example.quizandroid.activity1.login.LoginFragment.Companion.KEY_NAME_LOGIN
import com.example.quizandroid.activity1.login.LoginFragment.Companion.KEY_NAME_SIGNUP
import com.example.quizandroid.activity1.login.LoginFragment.Companion.KEY_PASS_LOGIN
import com.example.quizandroid.activity1.login.LoginFragment.Companion.KEY_PASS_SIGNUP
import com.example.quizandroid.databinding.FragmentSignUpBinding

class SignUpFragment : Fragment(R.layout.fragment_sign_up) {
    private lateinit var binding: FragmentSignUpBinding
    private val vmSignUp: SignUpViewModel by viewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DataBindingUtil.bind(view)!!          //باید بنویسیش
        binding.lifecycleOwner = this                   //باید بنویسیش
        binding.viewModelSignUp = vmSignUp                //باید بنویسیش

        vmSignUp.name2.value = requireArguments().getString(KEY_NAME_LOGIN).toString()
        vmSignUp.pass2.value = requireArguments().getString(KEY_PASS_LOGIN).toString()

        binding.btnSingUp2.setOnClickListener {
            val userName2 = binding.editTextUserName2.text.toString()
            val passWord2 = binding.editTextPassword2.text.toString()
            val bundle2 = bundleOf(KEY_NAME_SIGNUP to userName2, KEY_PASS_SIGNUP to passWord2)
            parentFragmentManager.commit {
                setReorderingAllowed(true)
                replace<LoginFragment>(R.id.container_view, args = bundle2)

            }
        }


    }
}