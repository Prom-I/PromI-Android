package com.promi.view.main

import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.promi.R
import com.promi.base.BaseFragment
import com.promi.databinding.FragmentCalendarBinding
import com.promi.viewmodel.main.CalendarViewModel
import com.promi.view.main.adapter.CalendarAdapter
import com.promi.view.main.dialog.TodoDialog
import java.util.Calendar
import java.util.Date

class CalendarFragment(index: Int): BaseFragment<FragmentCalendarBinding>(R.layout.fragment_calendar){
    private val viewModel by lazy {
        ViewModelProvider(requireParentFragment())[CalendarViewModel::class.java]
    }

    private lateinit var currentDate: Date
    private var pageIndex = index
    private var thisMonth = 0

    override fun initDataBinding() {
        super.initDataBinding()

        viewModel.setPosition(pageIndex)
        initDate()
        initCalendar()
    }

    private fun initDate() {
        // 이번달 pageIndex는 0
        pageIndex -= (Int.MAX_VALUE/2)
        if(pageIndex==0)
            thisMonth=1
        val date = Calendar.getInstance().run {
            add(Calendar.MONTH, pageIndex)
            time
        }
        Log.d("poss",pageIndex.toString())
        currentDate = date
    }
    private fun initCalendar() {
        val calendarAdapter = CalendarAdapter(binding.calendarLayout, currentDate, thisMonth)
        binding.listCalendarDate.apply {
            adapter = calendarAdapter
            layoutManager = GridLayoutManager(requireContext(), 7, GridLayoutManager.VERTICAL, false)
            setHasFixedSize(true)
        }

        calendarAdapter.setItemClickListener(object: CalendarAdapter.OnItemClickListener {
            override fun onClick(v: View, position: Int) {
                // val todoData = calendarAdapter.itemList[position]
                val year = calendarAdapter.year
                val month = calendarAdapter.month
                val date = calendarAdapter.dateData[position].toString()
                TodoDialog(year, month, date).show(parentFragmentManager,"TodoDialog")
            }
        })
    }
}