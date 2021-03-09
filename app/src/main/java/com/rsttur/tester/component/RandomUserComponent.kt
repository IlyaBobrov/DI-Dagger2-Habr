package com.rsttur.tester.component

import com.rsttur.tester.interfaces.RandomUsersApi
import com.rsttur.tester.module.PicassoModule
import com.rsttur.tester.module.RandomUsersModule
import com.squareup.picasso.Picasso
import dagger.Component

@Component(modules = [RandomUsersModule::class, PicassoModule::class])
interface RandomUserComponent {
    fun getRandomUserService() : RandomUsersApi
    fun getPicasso() : Picasso
}