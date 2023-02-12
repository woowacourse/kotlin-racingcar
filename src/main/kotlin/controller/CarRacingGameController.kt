package controller

import domain.game.CarRacingGame
import domain.generator.CarGenerator
import domain.validator.ValidateUseCases
import model.Car
import model.CarRacingGameDataSource
import view.InputView
import view.OutputView

class CarRacingGameController(
    private val carRacingGame: CarRacingGame = CarRacingGame(),
    private val carGenerator: CarGenerator = CarGenerator(),
    private val validateUseCases: ValidateUseCases = ValidateUseCases()
) {

    private val carRacingGameDataSource: CarRacingGameDataSource by lazy {
        CarRacingGameDataSource(initCars(), initNumberOfTry())
    }

    fun play() {
        runCatching {
            start(carRacingGameDataSource.cars, carRacingGameDataSource.numberOfTry)
            end(carRacingGameDataSource.cars)
        }.onFailure { exception ->
            OutputView.printErrorMsg(exception.message!!)
        }
    }

    private fun initCars(): List<Car> {
        val names = validateUseCases.validateSuccessiveTokenizer(InputView.inputCarNames())

        return carGenerator.generateCars(names)
    }

    private fun initNumberOfTry(): Int =
        validateUseCases.validateNumberOfTry(InputView.inputNumberOfTry())

    private fun start(cars: List<Car>, numberOfTry: Int) {
        repeat(numberOfTry) { count ->
            carRacingGame.moveCarsOneCycle(cars)
            OutputView.printPath(count, cars)
        }
    }

    private fun end(cars: List<Car>) {
        val winners = carRacingGame.getWinners(cars)

        OutputView.printWinner(winners)
    }
}
