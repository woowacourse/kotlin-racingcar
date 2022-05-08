package calculator

enum class Operator(
    private val operator: String,
    val calculate: (num1: Int, num2: Int) -> Int
) {
    PLUS("+", { num1, num2 -> num1 + num2 }),
    MINUS("-", { num1, num2 -> num1 - num2 }),
    MULTIPLE("*", { num1, num2 -> num1 * num2 }),
    DIVIDE("/", { num1, num2 -> num1 / num2 });

    companion object {
        fun of(operator: String): Operator {
            return values().find { it.operator == operator }
                ?: throw IllegalArgumentException("[ERROR] 존재하지 않는 연산자입니다.")
        }
    }
}
