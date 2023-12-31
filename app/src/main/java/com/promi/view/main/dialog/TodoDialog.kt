package com.promi.view.main.dialog

import com.promi.R
import com.promi.base.BaseDialogFragment
import com.promi.databinding.DialogTodoBinding

class TodoDialog(private val month: String, private val date: String, private val day: String)
    :BaseDialogFragment<DialogTodoBinding> (R.layout.dialog_todo) {

    override fun initDataBinding() {
        super.initDataBinding()

        val format: String = String.format(getString(R.string.todo_month_date_format), month, date, day)
        binding.tvTodoDate.text = format
    }
    override fun initAfterBinding() {
        super.initAfterBinding()

        binding.btnAddTodo.setOnClickListener {
            CategoryDialog(month, date, day).show(parentFragmentManager, "CategoryDialog")
        }
    }
}