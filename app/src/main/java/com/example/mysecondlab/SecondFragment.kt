package com.example.mysecondlab

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.mysecondlab.databinding.SecondFragmentBinding

class SecondFragment : Fragment() {
    private var _binding : SecondFragmentBinding? = null
    private val binding get() = _binding!!

    companion object{
        const val numberInArray = "number"
        const val name = "name"
        const val desc = "desc"
        const val url = "url"
        const val fullDesc = "fullDesc"
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = SecondFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvName.text = arguments?.getString(name)
        binding.tvDescription.text = arguments?.getString(desc)
        binding.tvSecondFullDesc.text = arguments?.getString(fullDesc)
        Glide.with(view).load(arguments?.getString(url)).fitCenter().into(binding.tvPhoto)


    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}