package com.example.daggermvvmbase.di.modules

import android.content.Context
import android.content.SharedPreferences
import com.example.daggermvvmbase.base.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class PrefrencesModule {

    /**
     * Provides Preferences object with MODE_PRIVATE
     */
    @Provides
    @Singleton
    fun provideSharedPreference(app: App): SharedPreferences =
        app.getSharedPreferences("SharedPreferences", Context.MODE_PRIVATE)

}
