package ru.tinkoff.lab4_11
import java.util.*

open class Cat {
    open fun hunt () {
        println("Я охочусь на мышей, ведь я кот!")
    }
}
class HomeCat : Cat() {
    fun hunt(choice: Boolean) {
        if(choice) super.hunt()
        else println("Ты че сдурел? Какие мыши? Иди корми меня, ленивая задница")
    }
}
fun main() {
    val scanner = Scanner(System.`in`)
    val homeCat = HomeCat()
    val choice = scanner.nextBoolean()
    homeCat.hunt(choice)
}