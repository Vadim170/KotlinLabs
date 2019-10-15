package ru.tinkoff.lab7_4

fun main(args: Array<String>) {
    val pet = Pet()
    with(pet) {
        nickname = "Mary"
        age = 21
        sex = Sex.FEMALE
    }
    println(pet)
    println(if(pet.isAddult()) "Совершеннолетняя" else "Несовершеннолетняя")
    println(pet.respectableNickname)

    val dog = Dog()
    dog.nickname = "Bobik"
    println(dog.respectableNickname)

    val dog2 : Pet = Dog()
    dog2.nickname = "Bobik"
    println(dog2.respectableNickname)

    // У dog2 вызовется свойство расширения от Pet
    // и напишет просто "Dear name", а не "Dear dog name"
    // Это может вызывать путанницу
}

enum class Sex {
    MALE, FEMALE
}

open class Pet {
    var nickname : String = ""
    var age : Int = 0
    var sex : Sex? = null

    override fun toString(): String {
        return "$nickname $age $sex"
    }
}

class Dog : Pet()

fun Pet.isAddult() = (age >= 2)

var Pet.respectableNickname: String
    get() = "Dear $nickname"
    set(value) {}

var Dog.respectableNickname: String
    get() = "Dear dog $nickname"
    set(value) {}

