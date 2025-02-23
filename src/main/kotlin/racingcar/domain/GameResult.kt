package racingcar.domain

class GameResult {
    private val str = StringBuilder()

    fun appendCar(
        carName: String,
        distance: Int,
    ): GameResult {
        str.append("$carName : ")
        repeat(distance) { str.append("-") }
        str.append("\n")
        return this
    }

    fun breakLine(): GameResult {
        str.append("\n")
        return this
    }

    override fun toString(): String = str.toString()
}
