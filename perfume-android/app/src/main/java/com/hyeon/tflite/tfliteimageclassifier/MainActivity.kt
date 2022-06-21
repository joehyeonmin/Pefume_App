package com.hyeon.tflite.tfliteimageclassifier

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.hyeon.tflite.tfliteimageclassifier.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import java.util.*


class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater, null, false) }

    private lateinit var tabLayout : TabLayout
    //private lateinit var fragmentManager : FragmentManager



    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 페이지 배경색 정보가 담긴 리스트
        val bgColors: MutableList<Int> = mutableListOf(
            android.R.color.holo_green_light,
            android.R.color.holo_blue_dark
        )

        setContentView(binding.root)


        // 실행가능코드
        // 뷰페이져에 프래그먼트 넣기
        binding.pager.adapter = ViewPagerAdapter(this)

        TabLayoutMediator(binding.tabLayout, binding.pager) { tab, position ->
            when (position) {
                0 -> tab.text = "PERFUME"
                1 -> tab.text = "FAVORITE"
                2 -> tab.text = "Weather"
            }
        }.attach()

        // 버튼 클릭 시 액티비티 전환
        binding.run {
            btnGallery.setOnClickListener {
                startActivity(Intent(this@MainActivity, GalleryActivity::class.java))
            }

            btnHistory.setOnClickListener {
                startActivity(Intent(this@MainActivity, HistoryActivity::class.java))
            }

            btnCamera.setOnClickListener {
                startActivity(Intent(this@MainActivity, CameraActivity::class.java))
            }
        }

    }
}