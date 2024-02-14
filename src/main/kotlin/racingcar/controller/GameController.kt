package racingcar.controller

import racingcar.domain.Car
import racingcar.service.WinnerService
import racingcar.util.ValidationUtil
import racingcar.view.InputView
import racingcar.view.OutputView
import kotlin.random.Random

class GameController {

    private val inputView = InputView()
    private val outputView = OutputView()
    private val validationUtil = ValidationUtil()
    private val winnerService = WinnerService()

    fun start() {
        //  사용자 입력 및 검증
        val carNames = getCarNames()
        val tryCounts = getTryCounts()

        // 레이싱 게임 실행
        val cars: List<Car> = carNames.map { Car(it) }
        playRacingGame(cars, tryCounts)

        // 결과 출력
        val winners = winnerService.findWinners(cars)
        outputView.printWinners(winners)
    }


    private fun getCarNames(): List<String> {
        while (true) {
            try {
                val carNames = inputView.readCarNames()
                validationUtil.validateCarNames(carNames)
                return carNames!!.split(",")
            } catch (e: IllegalArgumentException) {
                outputView.printErrorMessage(e.message!!)
            }
        }
    }

    private fun getTryCounts(): Int {
        while (true) {
            try {
                val tryCounts = inputView.readTryCounts()
                validationUtil.validateTryCounts(tryCounts)
                return tryCounts!!.toInt()
            } catch (e: IllegalArgumentException) {
                outputView.printErrorMessage(e.message!!)
            }
        }
    }

    private fun playRacingGame(cars: List<Car>, tryCounts: Int) {
        outputView.printResultMessage()
        repeat(tryCounts) {
            cars.forEach {
                it.move()
            }
            outputView.printRoundResult(cars)
        }
    }
}