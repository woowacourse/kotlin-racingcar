package racingcar.controller

import racingcar.InputValidator
import racingcar.model.Car
import racingcar.model.RacingGame
import racingcar.view.InputView
import racingcar.view.OutputView

class CarController(
    private val inputView: InputView,
    private val outputView: OutputView,
    private val inputValidator: InputValidator
) {
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
        val carNames = inputView.inputCarNames()
        return try {
            inputValidator.validateCarNames(carNames)
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
        val numberOfRound = inputView.inputNumberOfRound()
        return try {
            inputValidator.validateNumberOfRound(numberOfRound)
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
        outputView.outputStartGame()
        repeat(numberOfRound) {
            val randomNumbers = makeCarRandomNumber(cars = cars)
            racingGame.racingCars(randomNumbers = randomNumbers)
            outputView.outputRoundResults(cars = cars)
        }
    }

    private fun endRacingGame() {
        val winners = racingGame
            .judgeWinners()
            .map { winner ->
                winner.getName()
            }
        outputView.outputWinners(winners)
    }

    private fun makeCarRandomNumber(cars: List<Car>): List<Int> {
        return cars.map { car ->
            car.makeRandomNumber()
        }
    }
}
