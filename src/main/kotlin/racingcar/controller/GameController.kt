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
        val roundCounts = getRoundCounts()

        // 레이싱 게임 실행
        val cars: List<Car> = carNames.map { Car(it) }
        playRacingGame(cars, roundCounts)

        // 결과 출력
        val winners = winnerService.findWinners(cars)
        outputView.printWinners(winners)
    }


    private fun getCarNames(): List<String> {
        return runCatching {
            val carNames = inputView.readCarNames()
            validationUtil.validateCarNames(carNames)
            carNames.split(",")
        }.getOrElse { e ->
            if (e is IllegalArgumentException) {
                outputView.printErrorMessage(e.message!!)
            }
            getCarNames()
        }
    }


    private fun getRoundCounts(): Int {
        return runCatching {
            val roundCounts = inputView.readRoundCounts()
            validationUtil.validateRoundCounts(roundCounts)
            roundCounts.toInt()
        }.getOrElse { e ->
            if (e is IllegalArgumentException) {
                outputView.printErrorMessage(e.message!!)
            }
            getRoundCounts()
        }
    }

    private fun playRacingGame(cars: List<Car>, roundCounts: Int) {
        outputView.printResultMessage()
        repeat(roundCounts) {
            cars.forEach {
                val randomNumber = Random.nextInt(10)
                it.move(randomNumber)
            }
            outputView.printRoundResult(cars)
        }
    }
}
