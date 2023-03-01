package com.example.netflix.profile

import android.app.Activity
import android.app.Activity.RESULT_OK
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.registerForActivityResult
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.*
import com.example.netflix.R
import com.example.netflix.databinding.FragmentHomeBinding
import com.example.netflix.databinding.FragmentProfileBinding
import com.example.netflix.home.HomeViewModel


class ProfileFragment : Fragment(R.layout.fragment_profile) {
    private lateinit var binding: FragmentProfileBinding
    private val viewModelProfile: ProfileViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DataBindingUtil.bind(view)!!
        binding.lifecycleOwner = this
        binding.profileViewModelXML = viewModelProfile

        binding.btnSignup.setOnClickListener {

            viewModelProfile.name.value = binding.etName.text.toString()
            viewModelProfile.pass.value = binding.etPassword.text.toString()
            viewModelProfile.number.value = binding.etNumber.text.toString()
            if (viewModelProfile.checkEditTexts()) {
                parentFragmentManager.commit {
                    setReorderingAllowed(true)
                    replace<RegisterFragment>(R.id.container_view)
                }
            } else Toast.makeText(requireContext(), "اطلاعات رو کامل وارد کنید", Toast.LENGTH_SHORT).show()

        }

        val register =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == RESULT_OK) {
                    val selectImageUri: Uri? = result.data?.data
                    if (selectImageUri != null) {
                        viewModelProfile.uri.value = selectImageUri
                        binding.imageView.setImageURI(selectImageUri)
                    }
                }
            }

        binding.imageView.setOnClickListener {
            val intent = Intent()
            intent.type = "image/*"
            intent.action = Intent.ACTION_GET_CONTENT
            register.launch(intent)
        }


    }
}