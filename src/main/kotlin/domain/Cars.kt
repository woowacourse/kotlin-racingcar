package domain

import dto.RaceResult
import dto.Winners

class Cars(generator: NumberGenerator, names: List<String>) {
    private val cars = mutableListOf<Car>()

    init {
        verifyCarCount(names)
        verifyCarUniqueness(names)
        names.forEach { name -> cars.add(Car(generator, name)) }
    }

    fun raceOneTime(): List<RaceResult> {
        return cars.map { car -> car.race() }
    }

    fun findWinners(): Winners {
        val winnerDistance = findWinnerDistance()
        return getWinners(winnerDistance)
    }

    private fun verifyCarCount(names: List<String>) {
        require(names.size in 2..20) { "$ERROR_CAR_COUNT\n현재 자동차 개수 : ${names.size}대" }
    }

    private fun verifyCarUniqueness(names: List<String>) {
        require(names.size == names.distinct().size) { "$ERROR_CAR_UNIQUENESS\n전체 자동차 이름 : ${names.joinToString(",")}" }
    }

    private fun findWinnerDistance(): Int {
        var winnerDistance = 0
        cars.forEach { car -> winnerDistance = car.compareDistance(winnerDistance) }
        return winnerDistance
    }

    private fun getWinners(winnerDistance: Int): Winners {
        val winners = mutableListOf<String>()
        cars.forEach { car -> winners.add(car.getWinnerName(winnerDistance)) }
        return Winners(winners.filter { name -> name != "" })
    }

    companion object {
        const val ERROR_CAR_COUNT = "자동차 개수가 2대 이상 20대 이하가 아닙니다."
        const val ERROR_CAR_UNIQUENESS = "자동차 이름에 중복이 존재합니다."
    }
}
