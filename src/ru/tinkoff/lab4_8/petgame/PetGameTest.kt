package ru.tinkoff.lab4_8.petgame

import org.junit.Assert
import org.junit.Test
import java.io.ByteArrayInputStream

internal class PetGameTest {

    @Test
    fun start() {
        // Собака "Max" кормим 3 раза - сбегает
        var inStream = ByteArrayInputStream("1\nMax\n1\n1\n1".encodeToByteArray())
        System.setIn(inStream)
        Assert.assertNotNull(PetGame().start())

        // Кот "Lin don" кормим, убирает, кормим 3 раза раза - сбегает
        inStream = ByteArrayInputStream("2\nLin don\n1\n2\n1\n1\n1".encodeToByteArray())
        System.setIn(inStream)
        Assert.assertNotNull(PetGame().start())

        // Несуществующее животное
        inStream = ByteArrayInputStream("6\n5\nLex\n1\n1\n1".encodeToByteArray())
        System.setIn(inStream)
        Assert.assertNotNull(PetGame().start())

        // Несуществующее животное
        inStream = ByteArrayInputStream("0\n1\nLex\n1\n1\n1".encodeToByteArray())
        System.setIn(inStream)
        Assert.assertNotNull(PetGame().start())

        System.setIn(System.`in`)
    }
}