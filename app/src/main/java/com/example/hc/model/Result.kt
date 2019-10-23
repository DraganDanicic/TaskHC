package com.example.hc.model

import com.google.gson.annotations.SerializedName


data class Result (

    @SerializedName("results") val results : List<User>,
    @SerializedName("info") val info : Info
)