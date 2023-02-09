package view

import dto.CarMetadataDTO
import dto.WinnersDTO

class OutputView {
    fun printError(message: String) {
        println("$ERROR_HEADER $message")
    }

    fun printExecutionResult() {
        println(EXECUTION_RESULT)
    }

    fun printRaceResult(carMetadataDTO: CarMetadataDTO) {
        println("${carMetadataDTO.getName()} : ${"-".repeat(carMetadataDTO.getDistance())}")
    }

    fun printWinners(winnersDTO: WinnersDTO) {
        val winners = winnersDTO.getWinners()
        winners.joinToString { ", " }
    }

    fun printInterval() {
        println()
    }

    companion object {
        const val ERROR_HEADER = "[ERROR]"
        const val EXECUTION_RESULT = "실행 결과"
        const val FINAL_WINNER = "최종 우승자: "
    }
}
