package racingcar.controller

import racingcar.model.Car
import racingcar.model.RacingGame
import racingcar.util.Constant
import racingcar.util.InputValidator
import racingcar.view.InputView
import racingcar.view.OutputView

class CarController {
    private lateinit var racingGame: RacingGame

    fun run() {
        val cars = registerCars()
        val numberOfRound = registerRound()
        progressRacingGame(
            cars = cars,
            numberOfRound = numberOfRound
        )
    }

    private fun registerCars(): List<Car> {
        val carNames = InputView.inputCarNames()
        return try {
            InputValidator.validateCarNames(carNames)
            makeCars(carNames)
        } catch (e: IllegalArgumentException) {
            println(e.message)
            registerCars()
        }
    }

    private fun makeCars(carNames: List<String>): List<Car> {
        return carNames.map { name ->
            Car(name = name)
        }
    }

    private fun registerRound(): Int {
        val numberOfRound = InputView.inputNumberOfRound()
        return try {
            InputValidator.validateNumberOfRound(numberOfRound)
            numberOfRound.toInt()
        } catch (e: IllegalArgumentException) {
            println(e.message)
            registerRound()
        }
    }

    private fun progressRacingGame(
        cars: List<Car>,
        numberOfRound: Int
    ) {
        racingGame = RacingGame(cars = cars)
        OutputView.outputStartGame()
        repeat(numberOfRound) {
            racingGame.racingCars(randomBound = Pair(Constant.MIN_RANDOM_NUMBER, Constant.MAX_RANDOM_NUMBER))
            OutputView.outputRoundResults(cars = cars)
        }
        val winnerNames = racingGame.judgeWinners().map { winner -> winner.name }
        OutputView.outputWinnerNames(winnerNames)
    }
}
