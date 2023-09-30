package com.example.nongglenonggle.view.farmer.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.nongglenonggle.R
import com.example.nongglenonggle.view.farmer.mypage.FarmerMypageFragment
import com.example.nongglenonggle.view.farmer.notice.NoticeFragment
import com.example.nongglenonggle.view.farmer.search.SearchWorkerFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val bottomNavi = findViewById<BottomNavigationView>(R.id.bottom_navi)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer,FarmerhomeFragment())
            .commit()

        bottomNavi.setOnNavigationItemSelectedListener { item->
            var selectedFragment: Fragment?=null
            when(item.itemId){
                R.id.home_farmer -> {
                    selectedFragment=FarmerhomeFragment()
                }
                //일손찾기
                R.id.find_farmer->{
                    selectedFragment=SearchWorkerFragment()
                }
                //공고쓰기
                R.id.write_farmer->{
                    selectedFragment=NoticeFragment()
                }
                R.id.mypage_farmer->{
                    selectedFragment=FarmerMypageFragment()
                }

            }
            if(selectedFragment != null){
                supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, selectedFragment).commit()
            }
            true
        }
    }
    }