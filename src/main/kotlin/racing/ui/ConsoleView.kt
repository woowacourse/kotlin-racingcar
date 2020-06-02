package racing.ui

import racing.domain.Cars

object ConsoleView {
    fun getCarQuantityInput(): Int {
        println("자동차 대수는 몇 대 인가요?")
        return try {
            validate(readLine()!!.toInt())
        } catch (e: NumberFormatException) {
            getCarQuantityInput()
        }
    }

    fun getRaceRoundInput(): Int {
        println("시도할 회수는 몇 회 인가요?")
        return try {
            validate(readLine()!!.toInt())
        } catch (e: NumberFormatException) {
            getRaceRoundInput()
        }
    }

    private fun validate(value: Int): Int {
        if (value <= 0) {
            throw NumberFormatException()
        }
        return value
    }

    fun race(cars: Cars) {
        cars.status().forEach { println("-".repeat(it.value)) }
        println()
    }
}
