package ru.tinkoff.lab5_7

data class Person (
    val lastName: String,
    val firstName: String,
    val age: Int,
    val mailId: Int,
    val phoneNumber: String) {
    companion object : Comparator<Person>{
        override fun compare(o1: Person?, o2: Person?): Int {
            if(o1 == null || o2 == null) return 0
            return if(o1.lastName == o2.lastName &&
                o1.firstName == o2.firstName &&
                o1.age == o2.age &&
                o1.mailId == o2.mailId &&
                o1.phoneNumber == o2.phoneNumber)
                1
            else
                0
        }
    }
}

object PersonsComparator : Comparator<Person> {
    override fun compare(o1: Person?, o2: Person?): Int {
        if(o1 == null || o2 == null) return 0
        return if(o1.lastName == o2.lastName &&
            o1.firstName == o2.firstName &&
            o1.age == o2.age &&
            o1.mailId == o2.mailId &&
            o1.phoneNumber == o2.phoneNumber)
            1
        else
            0
    }
}

fun stringComparePersons(person1: Person, person2: Person, comparator: Comparator<Person>)
        = "${person1.firstName} ${if(comparator.compare(person1, person2) == 1) "идентичен" else "неидентичен"} ${person2.firstName}"

fun main() {
    val person1 = Person("Иванов", "Семён", 17, 330045, "+79209826345")
    val person2 = Person("Алёхин", "Виктор", 23, 330045, "+79219821315")
    val person3 = Person("Иванов", "Семён", 17, 330045, "+79209826345")
    println("Compare by PersonsComparator object:")
    println(stringComparePersons(person1,person2, PersonsComparator))
    println(stringComparePersons(person1,person3, PersonsComparator))
    println(stringComparePersons(person2,person3, PersonsComparator))
    println("Compare by companion object:")
    println(stringComparePersons(person1,person2, Person))
    println(stringComparePersons(person1,person3, Person))
    println(stringComparePersons(person2,person3, Person))
}