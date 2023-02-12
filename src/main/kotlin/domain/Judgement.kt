package domain

import dto.WinnersDTO

class Judgement(private val cars: List<Car>) {
    private var winnerDistance = 0

    fun findWinners(): WinnersDTO {
        findWinnerDistance()
        return getWinners()
    }

    private fun findWinnerDistance() {
        cars.map { car -> winnerDistance = car.compareDistance(winnerDistance) }
    }

    private fun getWinners(): WinnersDTO {
        val winners = mutableListOf<String>()
        cars.map { car -> winners.add(car.isWinner(winnerDistance)) }
        return WinnersDTO(winners.filter { name -> name != "" })
    }
}
