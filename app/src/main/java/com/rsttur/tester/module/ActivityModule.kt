package com.rsttur.tester.module

import android.app.Activity
import android.content.Context
import com.rsttur.tester.interfaces.RandomUserApplicationScope
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(var inputContext: Activity) {

    @RandomUserApplicationScope
    @Provides
    fun context() : Context = inputContext

}
/*

@Module
class ActivityModule internal constructor(context: Activity) {
    private val context: Context
    @RandomUserApplicationScope
    @Provides
    fun context(): Context {
        return context
    }

    init {
        this.context = context
    }
}*/
