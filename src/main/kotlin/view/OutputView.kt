package view

import dto.RaceResultDTO

class OutputView {
    fun printExecutionResult() {
        println(EXECUTION_RESULT)
    }

    fun printRaceResult(raceResultDTO: RaceResultDTO) {
        println(raceResultDTO.getResult())
    }

    companion object {
        const val EXECUTION_RESULT = "실행 결과"
    }
}
