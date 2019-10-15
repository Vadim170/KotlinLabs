package ru.tinkoff.lab7_3

fun main(args: Array<String>) {
    val pet = Pet()
    with(pet) {
        nickname = "Mary"
        age = 21
        sex = Sex.FEMALE
    }
    println(pet)
    println(if pet.isAddult() "Совершеннолетняя" else "Несовершеннолетняя")
    println(pet.respectableNickname)
}

enum class Sex {
    MALE, FEMALE
}

class Pet {
    var nickname : String = ""
    var age : Int = 0
    var sex : Sex? = null

    override fun toString(): String {
        return "$nickname $age $sex"
    }
}

fun Pet.isAddult() = (age >= 2)

var Pet.respectableNickname
    get() = "Dear $nickname"

