package com.example.homework11_leacture14

import java.io.Serializable

data class Animal(val id:Int,
                  val imige:Int,
                  val name:String,
                  val description:String,
                  val animalType:Kingdome,
                  val itemType:Int) :Serializable{

}

enum class Kingdome(name:String){
    DOG("dog"),
    CAT("cat"),
    RACOON("racoon"),
    SQUIRRLE("squirrle")
}