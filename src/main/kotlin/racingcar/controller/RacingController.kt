package racingcar.controller

import racingcar.model.car.Car
import racingcar.model.Round
import racingcar.service.RacingService
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingController(
    private val inputView: InputView = InputView(),
    private val outputView: OutputView = OutputView(),
    private val racingService: RacingService = RacingService(),
) {
    fun runRacing() {
        val cars = racingService.createCars(readCarNames())
        racingService.insertCars(cars)

        val round = readRound()

        runRounds(round.count, cars)

        val winners = getWinners()
        printWinners(winners)
    }

    private fun readCarNames(): List<String> {
        outputView.printMessage(CAR_NAMES_REQUEST_MESSAGE)
        return inputView.readCarNames()
    }

    private fun readRound(): Round {
        outputView.printMessage(ROUND_COUNT_REQUEST_MESSAGE)
        return Round(inputView.readNumber())
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

    private fun getWinners(): List<Car> = racingService.getWinners()

    companion object {
        private const val CAR_NAMES_REQUEST_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
        private const val ROUND_COUNT_REQUEST_MESSAGE = "시도할 횟수는 몇 회인가요?"
        private const val ROUNDS_RESULT_NOTIFICATION_MESSAGE = "\n실행 결과"
    }
}
