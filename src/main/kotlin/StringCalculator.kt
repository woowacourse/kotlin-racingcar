import kotlin.math.roundToInt

class StringCalculator {

    fun add(a: String, b: String): Float {
        validate(a, b)

        val numberA = a.toFloat()
        val numberB = b.toFloat()

        return numberA + numberB
    }

    private fun validate(a: String, b: String) {
        if (a.isBlank() || b.isBlank()) {
            throw IllegalArgumentException("빈 문자열이면 안 됩니다.")
        }
    }

    fun subtract(a: String, b: String): Float {
        validate(a, b)

        val numberA = a.toFloat()
        val numberB = b.toFloat()

        return numberA - numberB
    }

    fun multiply(a: String, b: String): Float {
        validate(a, b)

        val numberA = a.toFloat()
        val numberB = b.toFloat()

        return numberA * numberB

    }

    fun divide(a: String, b: String): Float {
        validate(a, b)

        val numberA: Float = a.toFloat()
        val numberB: Float = b.toFloat()

        validateDivideByZero(numberB)
        return numberA / numberB.roundToInt()
    }

    private fun validateDivideByZero(numberB: Float) {
        if (numberB == 0f) {
            throw IllegalArgumentException("0으로 나눌 수 없어요")
        }
    }

    fun calculate(s: String): String {
        val given = s.split(" ")

        val process = ArrayList<String>()
        process.add(given[0])
        for (i in 1 until given.size step 2) {
            val result = selectOperator(given[i], process.last(), given[i + 1])
            process.add(result)
        }

        return process.last()

    }

    private fun selectOperator(operator: String, a: String, b: String): String {
        if (operator == "+") {
            return add(a, b).toString()
        }
        if (operator == "-") {
            return subtract(a, b).toString()
        }
        if (operator == "*") {
            return multiply(a, b).toString()
        }
        if (operator == "/") {
            return divide(a, b).toString()
        }
        throw IllegalArgumentException("사칙연산 기호가 아니네요.")
    }

}