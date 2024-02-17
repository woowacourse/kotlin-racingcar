package racingcar.controller

import racingcar.model.Car
import racingcar.validator.Validation
import racingcar.view.InputView
import racingcar.view.OutputView

class Race {
    private val outputView = OutputView()
    private val inputView = InputView()
    private lateinit var cars: List<Car>
    private var roundNumber: Int = INITIAL_ROUND_NUMBER

    fun start() {
        cars = getCars()
        roundNumber = getRoundNumber()
        showResult(roundNumber)
        showWinners()
    }

    private fun getNames(): List<String> {
        outputView.printCarNamesGuide()
        lateinit var names: List<String>

        while (true) {
            kotlin.runCatching {
                names = inputView.readCarNames().split(COMMA)
                validateNames(names)
            }
                .onSuccess { return names }
                .onFailure { exception -> println(exception.message) }
        }
    }

    fun validateNames(names: List<String>) {
        Validation().carNameList(names)
        validateEachName(names)
    }

    private fun validateEachName(names: List<String>) {
        names.forEach { name ->
            Car(name)
        }
    }

    private fun getCars(): List<Car> {
        val names = getNames()
        val cars = mutableListOf<Car>()

        names.forEach { name ->
            cars.add(Car(name))
        }

        return cars
    }

    private fun getRoundNumber(): Int {
        outputView.printRoundNumberGuide()
        var roundNumber: Int

        while (true) {
            runCatching { getValidRoundNumber(inputView.readRoundNumber()) }
                .onSuccess { value ->
                    roundNumber = value
                    return roundNumber
                }
                .onFailure { exception -> println(exception.message) }
        }
    }

    fun getValidRoundNumber(roundNumberInput: String): Int {
        Validation().roundNumber(roundNumberInput)
        return roundNumberInput.toInt()
    }

    private fun showResult(roundNumber: Int) {
        outputView.printNewLine()
        outputView.printResultHeader()

        repeat(roundNumber) {
            showRaceStatus()
            outputView.printNewLine()
        }
    }

    private fun showRaceStatus() {
        cars.forEach { car ->
            car.move()
            outputView.printRaceResult(car.name, car.position)
        }
    }

    fun getWinners(cars: List<Car>): List<String> {
        val winners = mutableListOf<String>()
        val maxPosition = getMaxPosition(cars)

        cars.forEach { car ->
            judgeWinners(car, maxPosition, winners)
        }
        return winners
    }

    private fun judgeWinners(
        car: Car,
        maxPosition: Int,
        winners: MutableList<String>,
    ) {
        if (car.position == maxPosition) {
            winners.add(car.name)
        }
    }

    private fun getMaxPosition(cars: List<Car>): Int = cars.maxOfOrNull { it.position }!!

    private fun showWinners() {
        val winners = getWinners(cars)
        outputView.printWinner(winners)
    }

    companion object {
        private const val INITIAL_ROUND_NUMBER = 0

        private const val COMMA = ","
    }
}
