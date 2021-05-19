import java.lang.IllegalArgumentException
import kotlin.math.roundToInt

class StringCalculator {

    fun add(a:String, b:String): Int{
        validate(a,b)

        val numberA:Int = a.toInt()
        val numberB:Int = b.toInt()

        return numberA + numberB
    }

    private fun validate(a: String, b: String) {
        if(a.isNullOrBlank() || b.isNullOrBlank()){
            throw IllegalArgumentException("빈 문자열이면 안 됩니다.")
        }
    }

    fun subtract(a: String, b: String): Int {
        validate(a,b)

        val numberA:Int = a.toInt()
        val numberB:Int = b.toInt()

        return numberA - numberB
    }

    fun multiply(a: String, b: String): Int {
        validate(a,b)

        val numberA:Int = a.toInt()
        val numberB:Int = b.toInt()

        return numberA * numberB

    }

    fun divide(a: String, b: String): Float {
        validate(a,b)

        val numberA:Float = a.toFloat()
        val numberB:Float = b.toFloat()

        validateDivideByZero(numberB)
        return numberA / numberB.roundToInt()
    }

    private fun validateDivideByZero(numberB: Float) {
        if (numberB == 0f) {
            throw IllegalArgumentException("0으로 나눌 수 없어요")
        }
    }
}