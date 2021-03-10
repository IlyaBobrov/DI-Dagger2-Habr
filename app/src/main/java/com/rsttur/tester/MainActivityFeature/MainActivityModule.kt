package com.rsttur.tester.MainActivityFeature

import com.rsttur.tester.MainActivity
import com.rsttur.tester.adapter.RandomUserAdapter
import com.squareup.picasso.Picasso
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule(mainActivity: MainActivity) {

    @Provides
    @MainActivityScope
    fun randomUserAdapter(picasso: Picasso): RandomUserAdapter {
        return RandomUserAdapter(picasso)
    }


}