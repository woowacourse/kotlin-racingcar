package racingcar

import racingcar.domain.Car
import racingcar.domain.Configure.Companion.RANDOM_SEED
import racingcar.domain.Messages
import kotlin.random.Random

class RaceService {
    private val random = Random(RANDOM_SEED)
    private val outputView = OutputView()
    private val inputView = InputView()
    private val inputValidator = InputValidator()
    private val cars = mutableListOf<Car>()
    private var raceCount = 0

    fun carsInitializer() {
        cars.clear()
        outputView.showMessageToUser(Messages.USERINFO_INPUT_CAR_NAME.message, true)
        val carNamesUserInput = inputView.readUserInput()
        cars += getCarsByUserInput(carNamesUserInput)
    }

    private fun getCarsByUserInput(userInput: String): List<Car> {
        val carNames = userInput.split(",").map { it.trim() }
        val cars = carNames.map { Car(it) }
        inputValidator.duplicateCarNameCheck(cars)
        return cars
    }

    fun raceCountInitializer() {
        outputView.showMessageToUser(Messages.USERINFO_INPUT_RACE_COUNT.message, true)
        val raceCountUserInput = inputView.readUserInput()
        inputValidator.validRaceCountChecker(raceCountUserInput)
        raceCount = raceCountUserInput.toInt()
    }

    private fun filterWinCars(): List<Car> = cars.filter { it.distance == cars.maxOf { car -> car.distance } }

    fun showCarNamesByWinnerFormat() =
        outputView.showMessageToUser(
            Messages.WINNER_NAMES_ANNOUNCE.formattedMessage(
                filterWinCars().joinToString(", ") { it.name },
            ),
            true,
        )

    fun showRaceResultHeader() {
        outputView.showBlankLineToUser()
        outputView.showMessageToUser(Messages.RACE_RESULT.message, true)
    }

    fun doWholeRace() {
        repeat(raceCount) {
            doSingleRace(cars)
            outputView.showBlankLineToUser()
        }
    }

    private fun doSingleRace(cars: List<Car>) {
        cars.forEach { car ->
            car.moveByValue(random.nextInt(0, 10))
            outputView.showMessageToUser(car.toString(), true)
        }
    }
}
