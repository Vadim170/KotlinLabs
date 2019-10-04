import java.util.Scanner

val scan = Scanner(System.`in`)

fun makeCatVoice(e: Cat){
    e.voice()
}
open class Cat {
    open fun voice() {
        println("Meow meow meow!!!")
    }
}
class HomeCat(val name: String) : Cat() {
    override fun voice() {
        println("Meoooooow! Feed me, $name!")
    }
}
fun main(args: Array<String>) {
    val usualCat = Cat()        // Создаем обычного кота

    val name = scan.next()      // Считываем имя
    val homeCat = HomeCat(name) // Передаём в конструктор

    val num = scan.nextInt()

    repeat(num) {
        makeCatVoice(usualCat)
        makeCatVoice(homeCat)
    }
}