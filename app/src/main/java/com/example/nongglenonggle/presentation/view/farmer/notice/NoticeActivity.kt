package com.example.nongglenonggle.presentation.view.farmer.notice

import android.os.Bundle
import android.widget.FrameLayout
import androidx.activity.viewModels
import androidx.core.app.ActivityCompat
import androidx.viewpager2.widget.ViewPager2
import android.Manifest
import com.example.nongglenonggle.R
import com.example.nongglenonggle.presentation.base.BaseActivity
import com.example.nongglenonggle.databinding.ActivityNoticeBinding
import com.example.nongglenonggle.presentation.view.adapter.ViewPager2Adapter
import com.example.nongglenonggle.presentation.viewModel.farmer.FarmerNoticeViewModel
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NoticeActivity : BaseActivity<ActivityNoticeBinding>(R.layout.activity_notice) {
    private val viewModel: FarmerNoticeViewModel by viewModels()
    private lateinit var tablayout : TabLayout
    private lateinit var framelayout:FrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        tablayout = binding.tablayout

        binding.closebtn.setOnClickListener{
            finish()
        }

        initViewPager()
    }
    private fun initViewPager(){
        var viewPager2Adapter = ViewPager2Adapter(this)
        viewPager2Adapter.addfragment(noticeAFragment())
        viewPager2Adapter.addfragment(noticeBFragment())
        viewPager2Adapter.addfragment(noticeCFragment())
        viewPager2Adapter.addfragment(noticeDFragment())

        binding.viewpager.apply {
            adapter = viewPager2Adapter
            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                }
            })
        }
        TabLayoutMediator(binding.tablayout, binding.viewpager){
                tab,position->
            when(position){
                0 -> tab.text = "기본정보"
                1 -> tab.text = "작업내용"
                2 -> tab.text = "고용정보"
                3 -> tab.text = "추가내용"
            }
        }.attach()

    }
}