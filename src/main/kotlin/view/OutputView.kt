package view

import dto.RaceResultDTO

class OutputView {
    fun printError(message: String) {
        println("$ERROR_HEADER $message")
    }

    fun printExecutionResult() {
        println(EXECUTION_RESULT)
    }

    fun printRaceResult(carMetadataDTO: RaceResultDTO) {
        println("${carMetadataDTO.name} : ${"-".repeat(carMetadataDTO.distance)}")
    }

    fun printWinners(winners: List<String>) {
        println("$FINAL_WINNER ${winners.joinToString(", ")}")
    }

    fun printInterval() {
        println()
    }

    companion object {
        const val ERROR_HEADER = "[ERROR]"
        const val EXECUTION_RESULT = "실행 결과"
        const val FINAL_WINNER = "최종 우승자:"
    }
}
