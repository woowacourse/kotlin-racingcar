package domain

import dto.CarMetadataDTO
import dto.WinnersDTO

class Cars(generator: NumberGenerator, names: List<String>) {
    private val cars = mutableListOf<Car>()

    init {
        names.map { name -> cars.add(Car(generator, name)) }
    }

    fun raceOneTime(): List<CarMetadataDTO> {
        return cars.map { car -> car.race() }
    }

    fun findWinners(): WinnersDTO {
        val winnerDistance = findWinnerDistance()
        return getWinners(winnerDistance)
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
}
