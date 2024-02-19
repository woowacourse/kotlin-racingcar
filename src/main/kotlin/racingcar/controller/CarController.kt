package racingcar.controller

import racingcar.domain.Validator
import racingcar.domain.model.Car
import racingcar.domain.model.RacingGame
import racingcar.util.Constant
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
        endRacingGame()
    }

    private fun registerCars(): List<Car> {
        OutputView.outputRegisterCar()
        val carNames = InputView.inputCarNames()
        return try {
            Validator.validateCarNames(carNames)
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
        OutputView.outputRegisterNumberOfRoundRound()
        val numberOfRound = InputView.inputNumberOfRound()
        return try {
            Validator.validateNumberOfRound(numberOfRound)
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
            racingGame.racingCars(
                minNumber = Constant.MIN_RANDOM_NUMBER,
                maxNumber = Constant.MAX_RANDOM_NUMBER
            )
            OutputView.outputRoundResults(cars = cars)
        }
    }

    private fun endRacingGame() {
        val winners = racingGame
            .judgeWinners()
            .map { winner ->
                winner.getName()
            }
        OutputView.outputWinners(winners)
    }
}
