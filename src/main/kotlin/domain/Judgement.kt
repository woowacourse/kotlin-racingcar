package domain

import dto.RaceResultDTO
import dto.WinnersDTO

class Judgement(private val cars: List<Car>) {
    private var winnerDistance = 0
    private val winners = mutableListOf<String>()

    fun findWinners(): WinnersDTO {
        cars.map { car -> updateWinners(car.compare(winnerDistance)) }
        return WinnersDTO(winners)
    }

    private fun updateWinners(raceResultDTO: RaceResultDTO) {
        if (raceResultDTO.comparisonResult == ComparisonResult.LOSE) return

        if (raceResultDTO.comparisonResult == ComparisonResult.WIN) resetWinners(raceResultDTO.distance)
        addWinner(raceResultDTO.name)
    }

    private fun resetWinners(distance: Int) {
        winnerDistance = distance
        winners.clear()
    }

    private fun addWinner(name: String) {
        winners.add(name)
    }
}
