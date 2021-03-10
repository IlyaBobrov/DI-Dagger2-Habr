package com.rsttur.tester.MainActivityFeature

import com.rsttur.tester.MainActivity
import com.rsttur.tester.adapter.RandomUserAdapter
import com.rsttur.tester.component.RandomUserComponent
import com.rsttur.tester.interfaces.RandomUsersApi
import dagger.Component

@Component(modules = [MainActivityModule::class], dependencies = [RandomUserComponent::class])
@MainActivityScope
interface MainActivityComponent {
    fun injectMainActivity(mainActivity: MainActivity)
}