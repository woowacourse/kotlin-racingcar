package racingcar.view

import racingcar.racingcar.domain.RaceResultDto

class OutputView {
    fun printRaceResult(raceResultDto: RaceResultDto) {
        println(RESULT_PREFIX)
        raceResultDto.result.forEach { locations ->
            printCarsState(raceResultDto.names, locations)
        }
    }

    private fun printCarsState(names: List<String>, locations: List<Int>) {
        locations.forEachIndexed { i, _ ->
            printCarState(names[i], locations[i])
        }
        println()
    }

    private fun printCarState(name: String, location: Int) {
        println("$name : ${"-".repeat(location)}")
    }

    fun printWinner(names: List<String>) {
        print(WINNER + names.joinToString(", "))
    }

    companion object {
        private const val RESULT_PREFIX = "실행 결과"
        private const val WINNER = "최종 우승자: "
    }
}
