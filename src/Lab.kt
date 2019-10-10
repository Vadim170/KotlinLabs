package ru.tinkoff.lab6_8

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

fun main() {
    val pet = Pet()
    pet.apply { // Возвращает объект переданный в аргументе. Это не нужно, поэтому with в той же степени подходит
        nickname = "Tor"
        age = 12
        sex = Sex.MALE
    }
    println(pet)
    with(pet) { // Возвращает результат последнего лямбда-выражения. Это не нужно, поэтому apply в той же степени подходит
        nickname = "Mary"
        age = 21
        sex = Sex.FEMALE
    }
    println(pet)
    pet.also { // "it." это лишние символы, которые можно не писать.
        it.nickname = "Victor"
        it.age = 1
        it.sex = null
    }
    println(pet)
    pet.let { // "it." это лишние символы, которые можно не писать. И let применяют для null опасных типов, здесь это не требуется.
        it.nickname = "Kistocka"
        it.age = 2
        it.sex = null
    }
    println(pet)
}