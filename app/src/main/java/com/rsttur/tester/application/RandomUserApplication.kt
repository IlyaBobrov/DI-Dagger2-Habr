package com.rsttur.tester.application

import android.app.Activity
import android.app.Application
import com.rsttur.tester.component.DaggerRandomUserComponent
import com.rsttur.tester.component.RandomUserComponent
import com.rsttur.tester.module.ContextModule
import timber.log.Timber
import timber.log.Timber.DebugTree


class RandomUserApplication : Application() {

    var randomUserApplicationComponent: RandomUserComponent? = null
        private set

    override fun onCreate() {
        super.onCreate()
        Timber.plant(DebugTree())
        randomUserApplicationComponent = DaggerRandomUserComponent.builder()
            .contextModule(ContextModule(this))
            .build()
    }

    companion object {
        operator fun get(activity: Activity): RandomUserApplication {
            return activity.application as RandomUserApplication
        }
    }
}