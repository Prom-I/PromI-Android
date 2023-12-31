package com.promi.view.myInformation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.promi.R
import com.promi.databinding.FragmentMyInformationBinding
import com.promi.viewmodel.myinformation.MyInformationViewModel

class MyInformationFragment : Fragment() {

    private var _binding: FragmentMyInformationBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val MyInformationViewModel =
            ViewModelProvider(this)[MyInformationViewModel::class.java]
        _binding = FragmentMyInformationBinding.inflate(inflater, container, false)


        // 친구 목록 클릭시
        binding.constraintBtnFriendList.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_my_information_to_myFriendListFragment)
        }

        // 프로필 수정 클릭시
        binding.btnEditProfile.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_my_information_to_editProfileFragment)
        }

        // 형관펜 목록 클릭시
        binding.constraintBtnPaletteList.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_my_information_to_paletteListFragment)
        }



        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}