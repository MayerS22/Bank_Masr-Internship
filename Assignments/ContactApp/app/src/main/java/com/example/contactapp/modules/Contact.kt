package com.example.contactapp.modules

import androidx.annotation.StringRes

data class Contact(
    @StringRes val name: Int,
    @StringRes val phoneNumber: Int,
    @StringRes val picture: Int,
)
