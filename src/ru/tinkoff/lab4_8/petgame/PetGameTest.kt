package ru.tinkoff.lab4_8.petgame

import org.junit.Assert
import org.junit.Test
import java.io.ByteArrayInputStream

internal class PetGameTest {

    @Test
    fun start() {
        // ������ "Max" ������ 3 ���� - �������
        var inStream = ByteArrayInputStream("1\nMax\n1\n1\n1".encodeToByteArray())
        System.setIn(inStream)
        Assert.assertNotNull(PetGame().start())

        // ��� "Lin don" ������, �������, ������ 3 ���� ���� - �������
        inStream = ByteArrayInputStream("2\nLin don\n1\n2\n1\n1\n1".encodeToByteArray())
        System.setIn(inStream)
        Assert.assertNotNull(PetGame().start())

        // �������������� ��������
        inStream = ByteArrayInputStream("6\n5\nLex\n1\n1\n1".encodeToByteArray())
        System.setIn(inStream)
        Assert.assertNotNull(PetGame().start())

        // �������������� ��������
        inStream = ByteArrayInputStream("0\n1\nLex\n1\n1\n1".encodeToByteArray())
        System.setIn(inStream)
        Assert.assertNotNull(PetGame().start())

        System.setIn(System.`in`)
    }
}