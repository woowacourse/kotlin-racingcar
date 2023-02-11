package racingcar.controller

import racingcar.model.Round
import racingcar.model.car.Car
import racingcar.model.car.Cars
import racingcar.service.RacingService
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingController(
    private val inputView: InputView = InputView(),
    private val outputView: OutputView = OutputView(),
) {
    private lateinit var racingService: RacingService

    fun runRacing() {
        initRacingService()
        runRounds(readRound())

        val winners = getWinners()
        printWinners(winners)
    }

    private fun initRacingService() {
        racingService = RacingService(readCarNames())
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

    private fun printRoundResult(cars: Cars) = outputView.printRoundResult(cars)

    private fun printWinners(winners: List<Car>) = outputView.printWinners(winners)

    private fun runRounds(round: Round) {
        printRoundCountRequestMessage()
        racingService.runAllRounds(round) { eachRoundCars ->
            printRoundResult(eachRoundCars)
        }
    }

    private fun getWinners(): List<Car> = racingService.getWinners()

    companion object {
        private const val CAR_NAMES_REQUEST_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
        private const val ROUND_COUNT_REQUEST_MESSAGE = "시도할 횟수는 몇 회인가요?"
        private const val ROUNDS_RESULT_NOTIFICATION_MESSAGE = "\n실행 결과"
    }
}
