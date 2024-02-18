package racingcar.controller

import racingcar.domain.Car
import racingcar.service.WinnerService
import racingcar.util.ValidationUtil
import racingcar.view.InputView
import racingcar.view.OutputView

class GameController {

    private val validationUtil = ValidationUtil()
    private val winnerService = WinnerService()

    fun start() {
        //  사용자 입력 및 검증
        val carNames = getCarNames()
        val roundCounts = getRoundCounts()

        // 레이싱 게임 실행
        val cars: List<Car> = carNames.map { Car(it) }
        playRacingGame(cars, roundCounts)

        // 결과 출력
        val winners = winnerService.findWinners(cars)
        OutputView.printWinners(winners)
    }


    private fun getCarNames(): List<String> {
        while (true) {
            try {
                val carNames = InputView.readCarNames()
                validationUtil.validateCarNames(carNames)
                return carNames!!.split(",")
            } catch (e: IllegalArgumentException) {
                OutputView.printErrorMessage(e.message!!)
            }
        }
    }

    private fun getRoundCounts(): Int {
        while (true) {
            try {
                val roundCounts = InputView.readRoundCounts()
                validationUtil.validateRoundCounts(roundCounts)
                return roundCounts!!.toInt()
            } catch (e: IllegalArgumentException) {
                OutputView.printErrorMessage(e.message!!)
            }
        }
    }

    private fun playRacingGame(cars: List<Car>, roundCounts: Int) {
        OutputView.printResultMessage()
        repeat(roundCounts) {
            cars.forEach {
                it.move()
            }
            OutputView.printRoundResult(cars)
        }
    }
}
