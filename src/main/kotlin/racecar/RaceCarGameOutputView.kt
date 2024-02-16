package racecar

interface RaceCarGameOutputView {
    fun outputCarNamesRequest()

    fun outputTrialCountRequest()

    fun outputRaceResultTitle()

    fun outputRacingStatus(cars: List<RaceCar>)

    fun outputWinners(winner: List<RaceCar>)
}
