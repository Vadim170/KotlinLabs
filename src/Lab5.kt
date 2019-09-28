import java.util.*

//val scan = Scanner(System.`in`)
fun main(args: Array<String>) {
    val s = scan.next()
    print(isCapitalized(s))
}

fun isCapitalized(str: String) : Boolean {
    if(str.isEmpty()) throw  Exception("Zero string length")
    return str[0].isUpperCase()
}