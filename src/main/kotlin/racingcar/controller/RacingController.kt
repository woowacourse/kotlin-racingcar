package racingcar.controller

import racingcar.model.Car
import racingcar.service.RacingService
import racingcar.utils.Validator
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingController(
    private val inputView: InputView = InputView(Validator()),
    private val outputView: OutputView = OutputView(),
    private val racingService: RacingService = RacingService(),
) {
    fun runRacing() {
        val cars = createCars(readCarNames())
        val roundCount = readRoundCount()

        runRounds(roundCount, cars)

        val winners = getWinners(cars)
        printWinners(winners)
    }

    private fun readCarNames(): List<String> {
        outputView.printMessage(CAR_NAMES_REQUEST_MESSAGE)
        return inputView.readCarNames()
    }

    private fun readRoundCount(): Int {
        outputView.printMessage(ROUND_COUNT_REQUEST_MESSAGE)
        return inputView.readRoundCount()
    }

    private fun printRoundCountRequestMessage() = outputView.printMessage(ROUNDS_RESULT_NOTIFICATION_MESSAGE)

    private fun printRoundResult(cars: List<Car>) = outputView.printRoundResult(cars)

    private fun printWinners(winners: List<Car>) = outputView.printWinners(winners)

    private fun runRounds(roundCount: Int, cars: List<Car>) {
        printRoundCountRequestMessage()
        repeat(roundCount) {
            runRound(cars)
        }
    }

    private fun runRound(cars: List<Car>) {
        moveCarsRandomly(cars)
        printRoundResult(cars)
    }

    private fun moveCarsRandomly(cars: List<Car>) {
        cars.forEach { car ->
            racingService.moveRandomly(car)
        }
    }

    private fun createCars(carNames: List<String>): List<Car> =
        carNames.map { carName ->
            racingService.createCar(carName)
        }

    private fun getWinners(cars: List<Car>): List<Car> = racingService.getWinners(cars)

    companion object {
        const val CAR_NAMES_REQUEST_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
        const val ROUND_COUNT_REQUEST_MESSAGE = "시도할 횟수는 몇 회인가요?"
        const val ROUNDS_RESULT_NOTIFICATION_MESSAGE = "\n실행 결과"
        const val WINNER_NOTIFICATION_MESSAGE = "최종 우승자"
    }
}
