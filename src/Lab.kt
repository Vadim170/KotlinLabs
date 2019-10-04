package ru.tinkoff.lab4_5

abstract class Pet(val name: String, val age: Int)

class Dog(name: String,age: Int) : Pet(name,age)
class Cat(name: String,age: Int) : Pet(name,age)
class Parrot(name: String,age: Int) : Pet(name,age)
class Snake(name: String,age: Int) : Pet(name,age)
class Fish(name: String,age: Int) : Pet(name,age)

fun main(args: Array<String>){
    val dog = Dog("Bobik", 3)
    val cat = Cat("Mussy", 4)
    val parrot = Parrot("Mike", 5)
    val snake = Snake("Smith", 3)
    val fish = Fish("Nstya", 2)
}
