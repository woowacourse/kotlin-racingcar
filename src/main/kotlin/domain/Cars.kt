package domain

import dto.CarMetadataDTO
import dto.WinnersDTO

class Cars(generator: NumberGenerator, names: List<String>) {
    private val cars = mutableListOf<Car>()

    init {
        verifyCarCount(names)
        verifyCarUniqueness(names)
        names.map { name -> cars.add(Car(generator, name)) }
    }

    fun raceOneTime(): List<CarMetadataDTO> {
        return cars.map { car -> car.race() }
    }

    fun findWinners(): WinnersDTO {
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
        cars.map { car -> winnerDistance = car.compareDistance(winnerDistance) }
        return winnerDistance
    }

    private fun getWinners(winnerDistance: Int): WinnersDTO {
        val winners = mutableListOf<String>()
        cars.map { car -> winners.add(car.isWinner(winnerDistance)) }
        return WinnersDTO(winners.filter { name -> name != "" })
    }

    companion object {
        const val ERROR_CAR_COUNT = "자동차 개수가 2대 이상 20대 이하가 아닙니다."
        const val ERROR_CAR_UNIQUENESS = "자동차 이름에 중복이 존재합니다."
    }
}
