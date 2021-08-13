package com.example.profilecardlayout

data class UserProfile(
    val name: String,
    val status: Boolean,
    val drawableId: Int
)

val userProfileList = arrayListOf(
    UserProfile("John Doe", true, R.drawable.images),
    UserProfile("Jack Sparrow", false, R.drawable.images),
    UserProfile("Emilia", true, R.drawable.images),
    UserProfile("Alice", false, R.drawable.images),
    UserProfile("John Doe", true, R.drawable.images),
    UserProfile("Jack Sparrow", false, R.drawable.images),
    UserProfile("Emilia", true, R.drawable.images),
    UserProfile("Alice", false, R.drawable.images)

)