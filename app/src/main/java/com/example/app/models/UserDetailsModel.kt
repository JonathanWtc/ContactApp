package com.example.app.models


//baseUrl// https://androidtutorials.herokuapp.com/
//endPoint// usersFake
data class UserDetailsModel(
        val id : Int,
        val name : String,
        val lastName : String,
        val nickName : String
)
//data class UserResponse : List<UserDetailsModel>()