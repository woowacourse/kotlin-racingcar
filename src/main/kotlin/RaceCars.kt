class RaceCars(
    private val cars: List<RaceCar>,
    private val numberGenerator: NumberGenerator,
) {
    init {
        require(cars.distinct().size == cars.size) { "차는 중복될 수 없습니다." }
        require(cars.isNotEmpty()) { "차 리스트는 비어 있으면 안된다." }
    }

    private fun findWinnerCar() = cars.maxOf { it }
    fun findWinnerCars(): List<RaceCar> {
        val winnerCar = findWinnerCar()
        val winnerCars = cars.filter { it.isSamePosition(winnerCar) }
        return winnerCars
    }

    fun moveOrStop() {
        cars.forEach {
            it.moveOrStop(numberGenerator.generate())
        }
    }

    override fun toString() = StringBuilder()
        .apply { cars.forEach { append("$it\n") } }
        .toString()

    companion object {
        fun from(carNames: List<String>, numberGenerator: NumberGenerator): RaceCars {
            return RaceCars(carNames.map { RaceCar(it) }, numberGenerator)
        }
    }
}
