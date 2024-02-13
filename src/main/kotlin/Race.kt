class Race(
    carNames: List<String>,
    private val numberGenerator: NumberGenerator
) {
    private val cars =
        carNames.map {
            Car(it)
        }

    private fun runOneRound() {
        cars.forEach {
            it.moveOrStop(numberGenerator.generate())
        }
    }

    fun run(roundNum: Int) {
        repeat(roundNum) { runOneRound() }
    }

    fun getWinnerNames(): List<String> {
        val winnerCar = cars.maxOf { it }
        val winnerCars = cars.filter { it.compareTo(winnerCar) == 0 }
        return winnerCars.map { it.name }
    }

    override fun toString(): String {
        val sb = StringBuilder()
        cars.forEach {
            sb.append("$it\n")
        }
        return sb.toString()
    }
}
