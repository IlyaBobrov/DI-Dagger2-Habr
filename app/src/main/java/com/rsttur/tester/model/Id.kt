package com.rsttur.tester.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Id {
    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("value")
    @Expose
    var value: String? = null
}