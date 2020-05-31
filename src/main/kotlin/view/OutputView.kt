package view

import utils.ResultParser
import view.dto.PositionsDto
import view.dto.RoundDto

object OutputView {
    fun askNumberOfCar() {
        println("자동차 대수는 몇 대 인가요?")
    }

    fun askNumberOfRound() {
        println("시도할 횟수는 몇 회 인가요?")
    }

    fun showResult(roundDto: RoundDto) {
        roundDto.round.forEach { showRoundResult(it) }
    }

    private fun showRoundResult(positionsDto: PositionsDto) {
        positionsDto.positions
            .map { ResultParser.parseToDash(it) }
            .forEach { println(it) }
        println()
    }
}