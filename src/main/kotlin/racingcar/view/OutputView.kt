package racingcar.view

import racingcar.racingcar.domain.RaceResultDto

class OutputView {
    fun printRaceResult(raceResultDto: RaceResultDto) {
        println(OUTPUT_RESULT_PREFIX)
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
        print(OUTPUT_WINNER + names.joinToString(", "))
    }

    companion object {
        private const val OUTPUT_RESULT_PREFIX = "실행 결과"
        private const val OUTPUT_WINNER = "최종 우승자: "
    }
}
