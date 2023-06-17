package com.project.dombaapps.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.project.dombaapps.ui.adapter.FragmentAdapter
import com.project.dombaapps.R
import com.project.dombaapps.databinding.ActivityMainBinding
import com.project.dombaapps.ui.fragment.KambingFragment
import com.project.dombaapps.ui.fragment.SapiFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var viewPager = findViewById(R.id.viewPager) as ViewPager
        var tablayout = findViewById(R.id.tablayout) as TabLayout

        val fragmentAdapter = FragmentAdapter(supportFragmentManager)
        fragmentAdapter.addFragment(KambingFragment(), "Kambing")
        fragmentAdapter.addFragment(SapiFragment(), "Sapi")

        viewPager.adapter = fragmentAdapter
        tablayout.setupWithViewPager(viewPager)
//        binding.btnscan.setOnClickListener {
//            val intent = Intent(this,ScanActivity::class.java)
//            startActivity(intent)
//        }
//
//
//        binding.btnToAdmin.setOnClickListener {
//            val intent = Intent(this,AdminPageActivity::class.java)
//            startActivity(intent)
//        }
    }
}