package racecar.domain

class RaceCars(
    val cars: List<RaceCar>,
    private val scoreGenerator: ScoreGenerator,
) {
    init {
        require(cars.distinct().size == cars.size) { "차는 중복될 수 없습니다." }
        require(cars.isNotEmpty()) { "차 리스트는 비어 있으면 안된다." }
    }

    fun findWinners(): List<RaceCar> =
        with(cars) {
            val maxPosition = maxOf { it.position }
            val winnerCars = filter { maxPosition == it.position }
            return winnerCars
        }

    fun move() {
        cars.forEach {
            it.move(scoreGenerator.generate())
        }
    }

    override fun toString() =
        StringBuilder()
            .apply { cars.forEach { append("$it\n") } }
            .toString()

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as RaceCars

        if (cars != other.cars) return false
        if (scoreGenerator.generate() != other.scoreGenerator.generate()) return false

        return true
    }

    override fun hashCode(): Int {
        var result = cars.hashCode()
        result = 31 * result + scoreGenerator.generate().hashCode()
        return result
    }

    companion object {
        operator fun invoke(
            carNames: List<String>,
            scoreGenerator: ScoreGenerator,
        ): RaceCars {
            return RaceCars(carNames.map { RaceCar(it) }, scoreGenerator)
        }
    }
}
