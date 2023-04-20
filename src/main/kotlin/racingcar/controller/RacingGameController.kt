package racingcar.controller

import racingcar.domain.Car
import racingcar.domain.RacingGame
import racingcar.domain.strategy.NumberGenerator
import racingcar.view.CarDto
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingGameController(inputView: InputView, outputView: OutputView, numberGenerator: NumberGenerator) {

    private val inputView: InputView
    private val outputView: OutputView
    private val numberGenerator: NumberGenerator

    init {
        this.inputView = inputView
        this.outputView = outputView
        this.numberGenerator = numberGenerator
    }

    fun run() {
        val carNames: List<String> = inputView.readCarNames()
        val trialCount: Int = inputView.readTrialCount()
        val racingGame: RacingGame = RacingGame.initGame(carNames, trialCount)

        while (!racingGame.isEnd()) {
            racingGame.play(numberGenerator)
            outputView.printCarsPosition(toCarDtos(racingGame.cars.cars))
        }

        outputView.printWinners(toCarDtos(racingGame.getWinners()))
    }

    private fun toCarDtos(cars: List<Car>) = cars.map { CarDto(it.name, it.position) }
}
