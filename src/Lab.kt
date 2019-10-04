package ru.tinkoff.lab4_5
import java.util.Scanner

class Car() {
    fun ride(km: Int) {
        println("Поехали!")
        var kmLeft = km
        while(kmLeft > 0) {
            println("Осталось $kmLeft километров")
            --kmLeft
        }
        println("Приехали!")
    }
}
val scan = Scanner(System.`in`)
fun main(args: Array<String>) {
    val car = Car()
    car.ride(scan.nextInt())
}