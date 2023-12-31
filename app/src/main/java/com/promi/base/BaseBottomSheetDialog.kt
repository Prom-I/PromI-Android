package com.promi.base

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

abstract class BaseBottomSheetDialog<B: ViewDataBinding> (@LayoutRes private  val layoutResourceId: Int) :
    BottomSheetDialogFragment() {
    protected lateinit var binding: B

    protected open fun initStartView() {}
    protected open fun initDataBinding() {}
    protected open fun initAfterBinding() {}


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // false : 화면 밖 터치 혹은 뒤로가기 버튼 누를 시 dismiss 안됨
        isCancelable = true
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, layoutResourceId, container, false)

        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT)) // 둥근 모서리 적용
        dialog!!.window!!.setDimAmount(0.7F)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initStartView()
        initDataBinding()
        initAfterBinding()
    }

    protected fun shortToast(msg: String) =
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()

    protected fun longToast(msg: String) =
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show()
}