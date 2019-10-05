package ru.tinkoff.lab4_8.petgame

import ru.tinkoff.lab4_8.*
import java.util.*

class PetGame() {
    private var bunchShit = 0
    private lateinit var pet: Pet

    fun start() {
        pet = getPet()
        while (pet.isAvailable) {
            liveDay()
        }
    }

    private fun getPet(): Pet {
        val petAge = 0
        val petType = petGameUI.selectPetType()
        val petName = petGameUI.selectPetName()
        return when (petType) {
            1 -> Dog(petName, petAge)
            2 -> Cat(petName, petAge)
            3 -> Parrot(petName, petAge)
            4 -> Snake(petName, petAge)
            5 -> Fish(petName, petAge)
            else -> throw Exception("Указан неверный тип животного")
        }
    }

    private fun liveDay() {
        val action = petGameUI.selectAction()
        doAction(action)
        ++pet.age
    }

    private fun doAction(action: Int) {
        when (action) {
            1 -> {
                pet.eat()
                pet.shit()
                ++bunchShit
                if(bunchShit > 2) pet.isAvailable = false // Животное сбегает
                petGameUI.onEatSuccess()
            }
            2 -> {
                bunchShit = 0
                petGameUI.onClearSuccess()
            }
            else -> throw Exception("Указано неизвестное действие")
        }
        petGameUI.onActionSuccess()
    }

    // Реализация интерфейса пользователя
    val petGameUI = object : PetGameUI {
        var scanner = Scanner(System.`in`)

        override fun selectPetType(): Int {
            println("Выберите питомца:")
            println("(1-Собака; 2-Кошка; 3-Попугай; 4-Змея; 5-Рыбка)")
            var petType = scanner.nextInt()
            while (petType !in 1..5) {
                println("Не, таких животных у нас нет(пока)")
                println("Выберите питомца:")
                petType = scanner.nextInt()
            }
            return petType
        }

        override fun selectPetName(): String {
            scanner.nextLine()
            println("Введите имя вашего питомца:")
            return scanner.nextLine()
        }

        override fun selectAction() : Int {
            println("Что хотите сделать с вашим питомцем?")
            println("(1-Покормить; 2-Убрать за ним)")
            var action = scanner.nextInt()
            while (action !in 1..2) {
                println("Такое действие недоступно, повтори выбор:")
                action = scanner.nextInt()
            }
            return action
        }

        override fun onEatSuccess() {
            println("${pet.name} покушал и облегчился")
        }

        override fun onActionSuccess() {
            println(
                when (bunchShit) {
                    0 -> "Дома чисто и хорошо"
                    1 -> "${pet.name} слегда нагадил, стоит прибраться"
                    2 -> "Как можно жить, когда так грязно? Уберитесь!"
                    3 -> "${pet.name} не может жить с таким безолаберным хозяином"
                    else -> throw Exception("Ошибка в bunch of shit")
                }
            )
        }

        override fun onClearSuccess() {
            println("Вы убрасиль за ${pet.name}")
            println("${pet.name} уже ${pet.age} дней. Ему надо хорошо питаться")
        }
    }

    interface PetGameUI {
        fun selectPetType() : Int
        fun selectPetName() : String
        fun selectAction() : Int
        fun onEatSuccess()
        fun onClearSuccess()
        fun onActionSuccess()
    }
}