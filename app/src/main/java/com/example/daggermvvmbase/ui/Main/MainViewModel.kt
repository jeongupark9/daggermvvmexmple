package com.example.daggermvvmbase.ui.Main

import androidx.lifecycle.ViewModel
import com.example.daggermvvmbase.Repository.MainRepository
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val mainRepository: MainRepository
) : ViewModel() {

    fun getSplashPass(): String = "Pass Slpash"
    fun getNetwork() {
        mainRepository.runNetwork()
    }

    fun getRoomDB() {
        mainRepository.runRoomDB()
    }

}