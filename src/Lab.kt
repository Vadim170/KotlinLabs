package ru.tinkoff.lab5_6

data class Person(
    val lastName: String,
    val firstName: String,
    val age: Int,
    val mailId: Int,
    val phoneNumber: String
)

fun stringComparePersons(person1: Person, person2: Person)
        = "${person1.firstName} ${if(person1 == person2) "идентичен" else "неидентичен"} ${person2.firstName}"

fun main() {
    val person1 = Person("Иванов", "Семён", 17, 330045, "+79209826345")
    val person2 = Person("Алёхин", "Виктор", 23, 330045, "+79219821315")
    val person3 = Person("Иванов", "Семён", 17, 330045, "+79209826345")

    println(stringComparePersons(person1,person2))
    println(stringComparePersons(person1,person3))
    println(stringComparePersons(person2,person3))
}