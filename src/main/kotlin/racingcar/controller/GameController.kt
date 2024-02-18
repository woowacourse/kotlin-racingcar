package racingcar.controller

import racingcar.domain.Car
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

        // 레이싱 게임 실행
        val cars: List<Car> = carNames.map { Car(it) }
        playRacingGame(cars, roundCounts)

        // 결과 출력
        val winners = WinnerService.findWinners(cars)
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

    private fun playRacingGame(cars: List<Car>, roundCounts: Int) {
        OutputView.printResultMessage()
        repeat(roundCounts) {
            cars.forEach {
                it.move(Random.nextInt(10))
            }
            OutputView.printRoundResult(cars)
        }
    }
}
