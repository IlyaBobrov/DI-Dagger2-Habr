package com.rsttur.tester.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Registered {
    @SerializedName("date")
    @Expose
    var date: String? = null

    @SerializedName("age")
    @Expose
    var age: Int? = null
}