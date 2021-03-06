package com.sedra.sis.view.auth.signup

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.sedra.sis.R
import com.sedra.sis.databinding.FragmentSignUpPersonalDataBinding
import com.sedra.sis.view.auth.AuthViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignUpPersonalDataFragment : Fragment(R.layout.fragment_sign_up_personal_data) {

    val viewModel: AuthViewModel by activityViewModels()
    var binding: FragmentSignUpPersonalDataBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSignUpPersonalDataBinding.bind(view)
        binding?.apply {
            man.setOnClickListener {
                viewModel.gender = "male"
                man.setBackgroundResource(R.drawable.shape_stroke)
                woman.setBackgroundColor(resources.getColor(android.R.color.transparent))
            }
            woman.setOnClickListener {
                viewModel.gender = "female"
                man.setBackgroundColor(resources.getColor(android.R.color.transparent))
                woman.setBackgroundResource(R.drawable.shape_stroke)
            }
            nextSignUp.setOnClickListener {
                saveDataToViewModel(
                    registerName.text.toString(),
                    registerAge.text.toString(),
                    registerHeight.text.toString(),
                    registerWeight.text.toString()
                )
                findNavController().navigate(R.id.action_signUpPersonalDataFragment_to_signUpLoginDataFragment)
            }
        }
    }

    private fun saveDataToViewModel(
        name: String,
        age: String,
        height: String,
        weight: String,
    ) {
        viewModel.age = age.toInt()
        viewModel.name = name
        viewModel.height = height.toInt()
        viewModel.weight = weight.toInt()
    }
}