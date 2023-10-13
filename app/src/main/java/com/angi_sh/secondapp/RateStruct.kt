package com.angi_sh.secondapp

data class RateStruct (
        val disclaimer: String,
        val date: String,
        val timestamp: String,
        val base: String,
        val rates: HashMap<String, Double>,
)

