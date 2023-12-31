package com.promi.view.myInformation

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.promi.databinding.FragmentEditProfileBinding
import com.promi.view.myInformation.adapter.IncludedGroupAdapter
import com.promi.view.myInformation.dialog.SelectGroupScopeDialog

class EditProfileFragment : Fragment() {

    private lateinit var binding : FragmentEditProfileBinding
    private lateinit var tvNameCounter : TextView
    private lateinit var etEditName : EditText

    private lateinit var includedGroupAdapter: IncludedGroupAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentEditProfileBinding.inflate(layoutInflater)

        etEditName = binding.etEditName
        tvNameCounter = binding.tvNameCounter

        // if Back Button Clicked
        binding.btnBack.setOnClickListener {
            findNavController().popBackStack()
        }

        // EditText change Event
        etEditName.addTextChangedListener(object:TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                var nameSize = 0
                // if User input any text on EditText
                if(p0.toString().isNotEmpty()){
                    nameSize = p0.toString().length
                }
                tvNameCounter.text = "${nameSize}/10" // Change name counter
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        includedGroupAdapter = IncludedGroupAdapter()

        binding.listGroupIncluded.adapter = includedGroupAdapter

        includedGroupAdapter.setItemClickListener(object : IncludedGroupAdapter.OnItemClickListener{
            override fun onClick(v: View, position: Int) {
                SelectGroupScopeDialog().show(parentFragmentManager, "SelectGroupScopeDialog")
            }
        })
    }
}