package view

import dto.RaceResultDTO
import dto.WinnersDTO

class OutputView {
    fun printExecutionResult() {
        println(EXECUTION_RESULT)
    }

    fun printRaceResult(raceResultDTO: RaceResultDTO) {
        println(raceResultDTO.getResult())
    }

    fun printWinners(winnersDTO: WinnersDTO) {
        val winners = winnersDTO.getWinners()
        winners.joinToString { ", " }
    }

    companion object {
        const val EXECUTION_RESULT = "실행 결과"
        const val FINAL_WINNER = "최종 우승자: "
    }
}
