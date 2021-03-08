package com.rsttur.tester.module

import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class ContextModule(var context: Context) {

    @Provides
    fun context(): Context = context.applicationContext
}