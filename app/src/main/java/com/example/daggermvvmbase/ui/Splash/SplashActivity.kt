package com.example.daggermvvmbase.ui.Splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.daggermvvmbase.ui.Main.MainActivity
import com.example.daggermvvmbase.R
import com.example.daggermvvmbase.base.BaseActivity
import com.example.daggermvvmbase.databinding.ActivitySplashBinding

class SplashActivity : BaseActivity<ActivitySplashBinding>(layoutId = R.layout.activity_splash) {
    private val TAG = "SplashActivity"
    private lateinit var splashViewModel: SplashViewModel
    private var result: Boolean = false // splash에서 체크하는 내용들이 모두 체크가 되었을 경우 true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        splashViewModel = ViewModelProvider(this, viewModelFactory).get(SplashViewModel::class.java)

        splashViewModel.getNetwork()
        splashViewModel.getRoomDB()

    }

    override fun onResume() {
        super.onResume()
        splashViewModel.checkPermission()
        result = splashViewModel.checkInitInfo()
        showSplashHandler.sendEmptyMessageDelayed(0, 3000)
    }

    private val showSplashHandler = Handler(Handler.Callback { msg ->
        if (result) {
            goLoginMainActivity()
        } else {
            splashViewModel.checkInitInfo().also {
                if (it){
                    goLoginMainActivity()
                }else{
                    Log.e(TAG,"setting fail, app finish")
                }
            }

        }
        false
    })
    private fun goLoginMainActivity(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}