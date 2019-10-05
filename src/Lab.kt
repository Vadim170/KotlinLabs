package ru.tinkoff.lab4_8

import ru.tinkoff.lab4_8.petgame.PetGame

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

fun main(args: Array<String>) {
    try {
        val game = PetGame()
        game.start()
    } catch (e: Exception) {
        println("Произошла ошибка!(${e.message})")
        println(e.printStackTrace())
        println(e.toString())
    }
}


