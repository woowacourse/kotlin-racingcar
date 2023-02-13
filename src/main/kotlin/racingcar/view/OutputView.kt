package racingcar.view

import racingcar.racingcar.domain.raceresult.RaceResultDto
import racingcar.racingcar.domain.raceresult.StepResultDto

class OutputView {
    fun printRaceResult(raceResultDto: RaceResultDto) {
        println(RESULT_PREFIX)
        raceResultDto.result.forEach { stepResultDto ->
            printCarsState(stepResultDto)
        }
    }

    private fun printCarsState(stepResultDto: StepResultDto) {
        stepResultDto.racers.forEach { racerResultDto ->
            printCarState(racerResultDto.name, racerResultDto.location)
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
