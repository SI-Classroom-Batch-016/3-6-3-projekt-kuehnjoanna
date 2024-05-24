package com.example.wauwau.data

import com.example.wauwau.R

object Datasource {
    val data: List<Pet> = listOf(
        Pet("Johnny", 9, R.drawable.doggo, "Some description", "m"),
        Pet("Fafik", 1, R.drawable.doggo, "Some description", "m"),
        Pet("Luna", 13, R.drawable.doggo, "Some description", "f"),
        Pet("Marlon", 4, R.drawable.doggo, "Some description", "m"),
        Pet("Lucky", 6, R.drawable.doggo, "Some description", "m"),
        Pet("Yuki", 8, R.drawable.doggo, "Some description", "f"),
        Pet("Sasha", 9, R.drawable.doggo, "Some description", "f"),
        Pet("Leila", 10, R.drawable.doggo, "Some description", "f"),
        Pet("Tofik", 2, R.drawable.doggo, "Some description", "m"),
        Pet("Hera", 4, R.drawable.doggo, "Some description", "f"),
        Pet("Helga", 3, R.drawable.doggo, "Some description", "f"),
        Pet("Odin", 5, R.drawable.doggo, "Some description", "m"),
        Pet("Wallace", 7, R.drawable.doggo, "Some description", "m"),
        Pet("Rex", 2, R.drawable.doggo, "Some description", "m"),
        Pet("Max", 2, R.drawable.doggo, "Some description", "m"),
    )

    val messages: List<Message> = listOf(
        Message("Some message", "Text of some message"),

        Message("Some message2", "Text of some message2"),
        Message("Some message3", "Text of some message23"),
        Message("Some message24", "Text of some message24"),
    )

    val favorites: List<Pet> = listOf(
        Pet("Rex", 2, R.drawable.doggo, "Some description", "m"),

        )
}