package racecar

interface RaceCarGameOutputView {
    fun outputRaceResultTitle()

    fun outputRacingStatus(cars: List<RaceCar>)

    fun outputWinners(winner: List<RaceCar>)
}
