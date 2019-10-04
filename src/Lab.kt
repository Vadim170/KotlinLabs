package ru.tinkoff.lab4_6

import java.util.*

interface Flyable {
    fun fly()
}

interface Walkable {
    fun walk()
}

interface Swimable {
    fun swim()
}

interface Crawlable {
    fun crawl()
}

interface Voiceable {
    fun voice()
}

abstract class Pet(val name: String, var age: Int) {
    var isAvailable = true

    fun eat() {
        println("Ням-ням")
    }

    fun shit() {
        println("Пук-пук")
    }
}

class Dog(name: String,age: Int) : Pet(name,age), Voiceable, Walkable {
    override fun voice() {
        println("Гав")
    }

    override fun walk() {
        println("Ар-р-р")
    }
}

class Cat(name: String,age: Int) : Pet(name,age), Voiceable, Walkable {
    override fun voice() {
        println("Мяу")
    }

    override fun walk() {
        println("Кс-с-с")
    }
}

class Parrot(name: String,age: Int) : Pet(name,age), Flyable, Voiceable {
    override fun fly() {
        println("Вжух-вжух")
    }

    override fun voice() {
        println("Привет")
    }
}

class Snake(name: String,age: Int) : Pet(name,age), Swimable, Crawlable {
    override fun swim() {
        println("Бульк")
    }

    override fun crawl() {
        println("Чшшшш")
    }
}

class Fish(name: String,age: Int) : Pet(name,age), Swimable {
    override fun swim() {
        println("Журк-журк")
    }
}

class HomePet(var bunchShit: Int, val pet: Pet) {

    fun liveDay(scanner: Scanner) {
        println("Что хотите сделать с вашим питомцем?")
        println("(1-Покормить; 2-Убрать за ним)")
        var action = scanner.nextInt()
        while (action !in 1..2) {
            println("Такое действие недоступно, повтори выбор:")
            action = scanner.nextInt()
        }
        when (action) {
            1 -> {
                pet.eat()
                pet.shit()
                ++bunchShit
                println("${pet.name} покушал и облегчился")
            }
            2 -> {
                bunchShit = 0
                println("Вы убрасиль за ${pet.name}")
                println("${pet.name} уже ${pet.age} дней. Ему надо хорошо питаться")
            }
            else -> throw Exception("Указано неизвестное действие")
        }
        println(
            when (bunchShit) {
                0 -> "Дома чисто и хорошо"
                1 -> "${pet.name} слегда нагадил, стоит прибраться"
                2 -> "Как можно жить, когда так грязно? Уберитесь!"
                3 -> {
                    pet.isAvailable = false // Вызовет выход из цикла
                    "${pet.name} не смог жить с таким безолаберным хозяином"
                }
                else -> throw Exception("Ошибка в bunch of shit")
            }
        )
        ++pet.age
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    try {
        val pet = getPet(scanner)
        val homePet = HomePet(0, pet)
        while (homePet.pet.isAvailable) {
            homePet.liveDay(scanner)
        }
    } catch (e: Exception) {
        println("Произошла ошибка!(${e.message})")
        println(e.printStackTrace())
        println(e.toString())
    }
}

private fun getPet(scanner: Scanner): Pet {
    println("Выберите питомца:")
    println("(1-Собака; 2-Кошка; 3-Попугай; 4-Змея; 5-Рыбка)")
    var petType = scanner.nextInt()
    while (petType !in 1..5) {
        println("Не, таких животных у нас нет(пока)")
        println("Выберите питомца:")
        petType = scanner.nextInt()
    }

    scanner.nextLine()
    println("Введите имя вашего питомца:")
    val petName = scanner.nextLine()
    val petAge = 0

    return when (petType) {
        1 -> Dog(petName, petAge)
        2 -> Cat(petName, petAge)
        3 -> Parrot(petName, petAge)
        4 -> Snake(petName, petAge)
        5 -> Fish(petName, petAge)
        else -> throw Exception("Указан неверный тип животного")
    }
}

