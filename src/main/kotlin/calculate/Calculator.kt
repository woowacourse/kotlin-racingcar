package calculate

class Calculator {
    private val NUMBER_INDEX: Int = 0
    private val OPERATOR_INDEX: Int = 1

    fun operate(input: String): Number {
        val numbers = input.split(" ")
            .filterIndexed { index, value -> index % 2 == NUMBER_INDEX }
            .map { Number(it) }
            .toList()

        val operators = input.split(" ")
            .filterIndexed { index, value -> index % 2 == OPERATOR_INDEX }
            .map { Operator.of(it) }
            .toList()

        var sum:Number = numbers[0]
        for (index in operators.indices) {
            sum = operators[index].execute(sum, numbers[index + 1])
        }

        return sum
    }
}
