package view

import dto.CarMetadataDTO
import dto.WinnersDTO

class OutputView {
    fun printExecutionResult() {
        println(EXECUTION_RESULT)
    }

    fun printRaceResult(carMetadataDTO: CarMetadataDTO) {
        println("${carMetadataDTO.name} : ${"-".repeat(carMetadataDTO.distance)}")
    }

    fun printWinners(winnersDTO: WinnersDTO) {
        val winners = winnersDTO.winners
        println("$FINAL_WINNER ${winners.joinToString(", ")}")
    }

    fun printInterval() {
        println()
    }

    companion object {
        const val EXECUTION_RESULT = "실행 결과"
        const val FINAL_WINNER = "최종 우승자:"
    }
}
