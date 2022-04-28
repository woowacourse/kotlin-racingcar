package racingcar.controller

import racingcar.domain.MoveStrategy
import racingcar.domain.RacingGame
import racingcar.view.printRoundResult
import racingcar.view.printRoundResultText
import racingcar.view.printWinners
import racingcar.view.requestCarNames
import racingcar.view.requestTotalRounds

class Controller {

    fun run(moveStrategy: MoveStrategy) {
        val racingGame = initGame(moveStrategy)
        playGame(racingGame)
        printGameResult(racingGame)
    }

    private fun initGame(moveStrategy: MoveStrategy): RacingGame {
        val carNames = requestCarNames()
        val totalRounds = requestTotalRounds()
        return RacingGame(carNames, totalRounds, moveStrategy)
    }

    private fun playGame(racingGame: RacingGame) {
        printRoundResultText()
        while (!racingGame.isOver()) {
            racingGame.playRound()
            printRoundResult(racingGame.getCars())
        }
    }

    private fun printGameResult(racingGame: RacingGame) {
        val winners = racingGame.getWinners()
        printWinners(winners)
    }
}