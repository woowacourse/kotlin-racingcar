package calculate

import java.lang.IllegalArgumentException
import java.util.*
import java.util.function.BiFunction

enum class Operator(private val sign: String, private val function: BiFunction<Number, Number, Number>) {
    ADDITION("+", BiFunction { a: Number, b: Number -> a.add(b) }),
    SUBTRACTION("-", BiFunction { a: Number, b: Number -> a.subtract(b) }),
    MULTIPLICATION("*", BiFunction { a: Number, b: Number -> a.multiply(b) }),
    DIVISION("/", BiFunction { a: Number, b: Number -> a.divide(b) });

    companion object {
        fun of(sign: String): Operator {
            return Arrays.stream(values())
                .filter { it.sign == sign }
                .findAny()
                .orElseThrow { IllegalArgumentException("사칙연산 기호가 아닙니다.") }
        }
    }

    fun execute(a: Number, b: Number): Number = this.function.apply(a, b)
}
