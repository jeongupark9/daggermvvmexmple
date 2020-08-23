package com.example.daggermvvmbase.di.modules

import com.example.daggermvvmbase.ui.Main.MainActivity
import com.example.daggermvvmbase.ui.Splash.SplashActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(includes = [FragmentModule::class])
abstract class ActivityModules {


    @ContributesAndroidInjector
    abstract fun contributeSplahActivity() : SplashActivity

    @ContributesAndroidInjector
    abstract fun contributeMainActivity() : MainActivity
}