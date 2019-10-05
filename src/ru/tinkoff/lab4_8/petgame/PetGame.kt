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
            else -> throw Exception("������ �������� ��� ���������")
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
                if(bunchShit > 2) pet.isAvailable = false // �������� �������
                petGameUI.onEatSuccess()
            }
            2 -> {
                bunchShit = 0
                petGameUI.onClearSuccess()
            }
            else -> throw Exception("������� ����������� ��������")
        }
        petGameUI.onActionSuccess()
    }

    // ���������� ���������� ������������
    val petGameUI = object : PetGameUI {
        var scanner = Scanner(System.`in`)

        override fun selectPetType(): Int {
            println("�������� �������:")
            println("(1-������; 2-�����; 3-�������; 4-����; 5-�����)")
            var petType = scanner.nextInt()
            while (petType !in 1..5) {
                println("��, ����� �������� � ��� ���(����)")
                println("�������� �������:")
                petType = scanner.nextInt()
            }
            return petType
        }

        override fun selectPetName(): String {
            scanner.nextLine()
            println("������� ��� ������ �������:")
            return scanner.nextLine()
        }

        override fun selectAction() : Int {
            println("��� ������ ������� � ����� ��������?")
            println("(1-���������; 2-������ �� ���)")
            var action = scanner.nextInt()
            while (action !in 1..2) {
                println("����� �������� ����������, ������� �����:")
                action = scanner.nextInt()
            }
            return action
        }

        override fun onEatSuccess() {
            println("${pet.name} ������� � ����������")
        }

        override fun onActionSuccess() {
            println(
                when (bunchShit) {
                    0 -> "���� ����� � ������"
                    1 -> "${pet.name} ������ �������, ����� ����������"
                    2 -> "��� ����� ����, ����� ��� ������? ���������!"
                    3 -> "${pet.name} �� ����� ���� � ����� ������������ ��������"
                    else -> throw Exception("������ � bunch of shit")
                }
            )
        }

        override fun onClearSuccess() {
            println("�� �������� �� ${pet.name}")
            println("${pet.name} ��� ${pet.age} ����. ��� ���� ������ ��������")
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