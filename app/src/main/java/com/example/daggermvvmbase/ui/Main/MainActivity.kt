package com.example.daggermvvmbase.ui.Main

import android.os.Bundle
import com.example.daggermvvmbase.R
import com.example.daggermvvmbase.base.BaseActivity
import com.example.daggermvvmbase.databinding.ActivitySplashBinding

class MainActivity : BaseActivity<ActivitySplashBinding>(layoutId = R.layout.activity_main)  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}