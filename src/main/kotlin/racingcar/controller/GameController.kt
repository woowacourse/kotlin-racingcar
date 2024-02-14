package racingcar.controller

import racingcar.domain.Car
import racingcar.util.ValidationUtil
import racingcar.view.InputView
import racingcar.view.OutputView
import kotlin.random.Random

class GameController {
    val inputView = InputView()
    val outputView = OutputView()
    val validationUtil = ValidationUtil()
    fun start() {
        //  사용자 입력 및 검증
        val carNames = getCarNames()
        val tryCounts = getTryCounts()

        // 레이싱 게임 실행
        val cars: List<Car> = carNames.map { Car(it) }
        outputView.printResultMessage()
        repeat(tryCounts) {
            cars.forEach {
                it.move()
            }
            outputView.printRoundResult(cars)
        }

        // 결과 출력
        val maxPosition = cars.maxOfOrNull { it.position }
        val winners = cars.filter { it.position == maxPosition }.map { it.name }
        outputView.printWinners(winners)
    }


    fun getCarNames(): List<String> {
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

    fun getTryCounts(): Int {
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


}