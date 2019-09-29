import kotlin.math.min

fun min(num1: Int, num2: Int, num3: Int, num4: Int) : Int {
    return when {
        (num1 <= num2 && num1 <= num3 && num1 <= num4) -> num1
        (num2 <= num1 && num2 <= num3 && num2 <= num4) -> num2
        (num3 <= num1 && num3 <= num2 && num3 <= num4) -> num3
        (num4 <= num1 && num4 <= num2 && num4 <= num3) -> num4
        else -> 0
    }
}