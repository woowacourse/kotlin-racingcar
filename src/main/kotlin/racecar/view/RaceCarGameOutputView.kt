package racecar.view

import racecar.domain.RaceCar

interface RaceCarGameOutputView {
    fun outputRaceResultTitle()

    fun outputRacingStatus(cars: List<RaceCar>)

    fun outputWinners(winner: List<RaceCar>)
}
