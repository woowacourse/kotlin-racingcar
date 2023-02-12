package view

import dto.CarMetadata
import dto.Winners

class OutputView {
    fun printExecutionResult() {
        println(EXECUTION_RESULT)
    }

    fun printRaceResult(carMetadata: CarMetadata) {
        println("${carMetadata.name} : ${"-".repeat(carMetadata.distance)}")
    }

    fun printWinners(winners: Winners) {
        val winners = winners.names
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
