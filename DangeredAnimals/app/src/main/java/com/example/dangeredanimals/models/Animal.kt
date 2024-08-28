package com.example.dangeredanimals.models

import androidx.annotation.StringRes

data class Animal(
    @StringRes val name: Int,
    @StringRes val description: Int,
    @StringRes val picture: Int,
    val link: String

)
