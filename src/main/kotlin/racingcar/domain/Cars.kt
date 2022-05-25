package racingcar.domain

class Cars(val values: List<Car>) {

    fun findWinners(): List<Car> {
        val maxPosition = values.maxOf { it.position }
        return values.filter { it.position == maxPosition }
    }

    fun moveAll() {
        values.forEach { it.move((1..9).random()) }
    }
}
