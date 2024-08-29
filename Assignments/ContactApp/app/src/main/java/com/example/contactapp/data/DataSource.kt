package com.example.contactapp.data

import android.annotation.SuppressLint
import com.example.contactapp.R
import com.example.contactapp.modules.Contact


class DataSource {
    @SuppressLint("ResourceType")
    fun getContactsData(): List<Contact> {
        val contacts = mutableListOf<Contact>()
        contacts.add(
            Contact(
                R.string.auntie_name,
                R.string.auntie_phone,
                R.drawable.auntie
            )
        )
        contacts.add(
            Contact(
                R.string.brother_name,
                R.string.brother_phone,
                R.drawable.brother
            )
        )
        contacts.add(
            Contact(
                R.string.daughter_name,
                R.string.daughter_phone,
                R.drawable.daughter
            )
        )

        contacts.add(
            Contact(
                R.string.friend1_name,
                R.string.friend1_phone,
                R.drawable.friend_1
            )
        )

        contacts.add(
            Contact(
                R.string.friend2_name,
                R.string.friend2_phone,
                R.drawable.friend_2
            )
        )

        contacts.add(
            Contact(
                R.string.grandfather_name,
                R.string.grandfather_phone,
                R.drawable.grandfather
            )
        )

        contacts.add(
            Contact(
                R.string.granny_name,
                R.string.granny_phone,
                R.drawable.granny
            )
        )

        contacts.add(
            Contact(
                R.string.neighbour_name,
                R.string.neighbour_phone,
                R.drawable.neigbour
            )
        )

        contacts.add(
            Contact(
                R.string.sister_name,
                R.string.sister_phone,
                R.drawable.sister
            )
        )

        contacts.add(
            Contact(
                R.string.son_name,
                R.string.son_phone,
                R.drawable.son
            )
        )

        contacts.add(
            Contact(
                R.string.uncle_name,
                R.string.uncle_phone,
                R.drawable.uncle
            )
        )
        return contacts
    }
}