package com.rsttur.tester.module

import android.content.Context
import com.rsttur.tester.interfaces.ApplicationContext
import com.rsttur.tester.interfaces.RandomUserApplicationScope
import dagger.Module
import dagger.Provides

@Module
class ContextModule(var context: Context) {

    @ApplicationContext
    @RandomUserApplicationScope
    @Provides
    fun context(): Context = context.applicationContext
}