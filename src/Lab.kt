package ru.tinkoff.lab7_5

fun main(args: Array<String>) {
    // Создадим хозяина Pet
    val pet = Pet()
    with(pet) {
        nickname = "Mary"
        age = 21
        sex = Sex.FEMALE
    }
    println(if(pet.isAddult()) "Совершеннолетняя" else "Несовершеннолетняя")
    println(pet.respectableNickname)
    val owner = Owner(pet)
    owner.feed()
    // Создадим хозяина Dog
    val dog = Dog()
    dog.nickname = "Charly"
    println(dog.respectableNickname)
    val dogOwner = Owner(dog)
    dogOwner.feed()
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

class Cat : Pet()

fun Pet.isAddult() = (age >= 2)

var Pet.respectableNickname: String
    get() = "Dear $nickname"
    set(value) {}

class Owner<T : Pet>(val pet: T) {
    fun feed() = println("Домашнее животное ${pet.nickname} накормлено")
}

