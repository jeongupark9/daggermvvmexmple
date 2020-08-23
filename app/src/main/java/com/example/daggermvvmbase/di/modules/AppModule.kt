package com.example.daggermvvmbase.di.modules

import android.content.Context
import android.content.res.Resources
import androidx.room.Room
import com.example.daggermvvmbase.NetworkApi.ApiService
import com.example.daggermvvmbase.base.App
import com.example.daggermvvmbase.db.AppDatabase
import com.example.daggermvvmbase.db.Dao.SplashDao
import com.example.daggermvvmbase.util.Config
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton


@Module(includes = [ActivityModules::class, ViewModelModule::class,PrefrencesModule::class])
class AppModule {

    @Singleton
    @Provides
    fun provideApiService(): ApiService {
        return Retrofit.Builder()
            .baseUrl(Config.BASE_URL)
            .build()
            .create(ApiService::class.java)
    }
    /**
     * Provides app AppDatabase
     */
    @Singleton
    @Provides
    fun provideDb(context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "step_by_step_db").build()
    }


    /**
     * Provides NewsArticlesDao an object to access NewsArticles table from Database
     */
    @Singleton
    @Provides
    fun provideUserDao(db: AppDatabase): SplashDao {
        return db.splashDao()
    }
    /**
     * Application application level context.
     */
    @Singleton
    @Provides
    fun provideContext(application: App): Context {
        return application.applicationContext
    }


    /**
     * Application resource provider, so that we can get the Drawable, Color, String etc at runtime
     */
    @Provides
    @Singleton
    fun providesResources(application: App): Resources = application.resources
}