package calculator

enum class Operator(val op: String, val calculation: (Int, Int) -> Int) {
    ADD("+", { num1, num2 -> num1 + num2 }),
    SUBTRACT("-", { num1, num2 -> num1 - num2 }),
    MULTIPLY("*", { num1, num2 -> num1 * num2 }),
    DIVIDE("/", { num1, num2 -> num1 / num2 });

    fun calculate(num1: Int, num2: Int): Int {
        return calculation(num1, num2)
    }

    companion object {
        fun of(op: String): Operator {
            return values().firstOrNull { item -> item.op == op }
                ?: throw IllegalArgumentException("존재하지 않는 연산자입니다.")
        }
    }
}
