import java.util.*

val scanner = Scanner(System.`in`)
fun main(args: Array<String>){
    try {
        println("Введите Имя:")
        val name = scanner.nextLine()
        println("Введите число 1:")
        val num1 = scanner.nextInt()
        println("Введите число 2:")
        val num2 = scanner.nextInt()
        println("$name получает $num1 через $num2 лет.")
    } catch (e: InputMismatchException) {
        print("Ошибка ввода целого числа")
    }
}