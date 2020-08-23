package com.example.daggermvvmbase.ui.Splash

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.daggermvvmbase.Repository.SplashRepository
import javax.inject.Inject

class SplashViewModel @Inject constructor(
    private val splashRepository: SplashRepository
) : ViewModel() {

    fun getSplashPass(): String = "Pass Slpash"
    fun getNetwork() {
        splashRepository.runNetwork()
    }

    fun getRoomDB() {
        splashRepository.runRoomDB()
    }

    // 우선 퍼미션 부터 체크 , 이유는 퍼미션 체크 후 다음 splash 단계에서 체크할 사항 체
    fun checkPermission() {

    }

    // Splah 단계에서 체크할 사항을 모두 체크, 모든 관정 중 1개라도 안되면 다시 체크
    fun checkInitInfo(): Boolean {

        if (!checkVersion()|| !checkServiceOnOff() || !loadPhoneInfo()) {
            return false
        }
        return true
    }

    // 버전 체크 버전 체크 시 최소 버전보다 낮으면 업데이트로 이동 시켜야함
    private fun checkVersion() : Boolean{
        return true
    }

    // Service On/Off 체크
    private fun checkServiceOnOff(): Boolean {
        return true
    }


    private fun loadPhoneInfo() : Boolean{
       return splashRepository.setPhoneInfo()
    }
}