package racingcar.racingcar.view

import racingcar.racingcar.domain.RaceResultDto

interface OutputInterface {
    fun printRaceResult(raceResultDto: RaceResultDto)
    fun printCarsState(names: List<String>, locations: List<Int>)
    fun printCarState(name: String, location: Int)
    fun printWinner(names: List<String>)
}
