package racingcar.controller

import racingcar.domain.Car
import racingcar.domain.RacingGame
import racingcar.service.WinnerService
import racingcar.util.ValidationUtil
import racingcar.view.InputView
import racingcar.view.OutputView
import kotlin.random.Random

class GameController {

    fun start() {
        //  사용자 입력 및 검증
        val carNames = getCarNames()
        val roundCounts = getRoundCounts()

        // 자동차 경주 준비 및 시작
        val racingGame = RacingGame(carNames)
        playRacingGame(racingGame, roundCounts)

        // 결과 출력
        val winners = WinnerService.findWinners(racingGame.cars)
        OutputView.printWinners(winners)
    }

    private fun getCarNames(): List<String> {
        return runCatching {
            val carNames = InputView.readCarNames()
            ValidationUtil.validateCarNames(carNames)
            carNames!!.split(",")
        }.getOrElse { exception ->
            if(exception is IllegalArgumentException) {
                OutputView.printErrorMessage(exception.message!!)
            }
            getCarNames()
        }
    }

    private fun getRoundCounts(): Int {
        return runCatching {
            val roundCounts = InputView.readRoundCounts()
            ValidationUtil.validateCarNames(roundCounts)
            return roundCounts!!.toInt()
        }.getOrElse { exception ->
            if(exception is IllegalArgumentException) {
                OutputView.printErrorMessage(exception.message!!)
            }
            getRoundCounts()
        }
    }

    private fun playRacingGame(racingGame: RacingGame, roundCounts: Int) {
        OutputView.printResultMessage()
        repeat(roundCounts) {
            racingGame.playOneRound()
            OutputView.printRoundResult(racingGame.cars)
        }
    }
}
