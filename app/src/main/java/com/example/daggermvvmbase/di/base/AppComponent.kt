package com.example.daggermvvmbase.di.base
import com.example.daggermvvmbase.base.App
import com.example.daggermvvmbase.di.modules.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class, AppModule::class,AndroidSupportInjectionModule::class])
interface AppComponent : AndroidInjector<App>  {
    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(app: App): Builder

        fun build(): AppComponent
    }

}