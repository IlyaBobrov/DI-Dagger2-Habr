package com.rsttur.tester.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import org.apache.commons.lang3.builder.ToStringBuilder


class Example {
    @SerializedName("results")
    @Expose
    var results: List<Result>? = null

    @SerializedName("info")
    @Expose
    var info: Info? = null
}