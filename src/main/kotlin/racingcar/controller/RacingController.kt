package racingcar.controller

import racingcar.dto.car.CarsDto
import racingcar.model.car.WinnersDto
import racingcar.model.round.RoundDto
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
        val round = readRound()
        runRounds(round)

        val winners = getWinners()
        printWinners(winners)
    }

    private fun initRacingService() {
        racingService = RacingService(readCarNames())
    }

    private fun readCarNames(): CarsDto {
        outputView.printMessage(CAR_NAMES_REQUEST_MESSAGE)
        return inputView.readCarNames()
    }

    private fun readRound(): RoundDto {
        outputView.printMessage(ROUND_COUNT_REQUEST_MESSAGE)
        return inputView.readRound()
    }

    private fun printRoundCountRequestMessage() = outputView.printMessage(ROUNDS_RESULT_NOTIFICATION_MESSAGE)

    private fun printRoundResult(cars: CarsDto) = outputView.printRoundResult(cars)

    private fun printWinners(winners: WinnersDto) = outputView.printWinners(winners)

    private fun runRounds(round: RoundDto) {
        printRoundCountRequestMessage()
        racingService.runAllRounds(round) { eachRoundCars ->
            printRoundResult(eachRoundCars)
        }
    }

    private fun getWinners(): WinnersDto = racingService.getWinners()

    companion object {
        private const val CAR_NAMES_REQUEST_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
        private const val ROUND_COUNT_REQUEST_MESSAGE = "시도할 횟수는 몇 회인가요?"
        private const val ROUNDS_RESULT_NOTIFICATION_MESSAGE = "\n실행 결과"
    }
}
