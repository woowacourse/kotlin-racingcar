package racingcar.model

import racingcar.view.InputView
import racingcar.view.OutputView

class RaceManager {
    private val outputView = OutputView()
    private val inputView = InputView()

    private lateinit var cars: List<Car>

    fun showCarNamesGuide() = outputView.printCarNamesGuide()

    private fun getNames() = inputView.readCarNames()

    fun splitNames(names: String): List<String> = names.split(COMMA)

    fun getCars(): List<Car> {
        var names: List<String>

        while (true) {
            try {
                names = getNames()
                cars = Cars(names).makeCars()
                break
            } catch (e: IllegalArgumentException) {
                outputView.printErrorMessage(e.message)
            }
        }
        return cars
    }

    fun showRoundNumberGuide() = outputView.printRoundNumberGuide()

    private fun getRoundNumberInput() = inputView.readRoundNumber()

    fun getRoundNumber(): Int {
        var roundNumber: String

        while (true) {
            try {
                roundNumber = getRoundNumberInput()
                break
            } catch (e: IllegalArgumentException) {
                outputView.printErrorMessage(e.message)
            }
        }
        return roundNumber.toInt()
    }

    fun showResult(roundNumber: Int) {
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

    private fun getWinners(cars: List<Car>): List<String> {
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

    private fun getMaxPosition(cars: List<Car>) = cars.maxOfOrNull { it.position } ?: 0

    fun showWinners() {
        val winners = getWinners(cars)
        outputView.printWinner(winners)
    }

    companion object {
        const val COMMA = ","
    }
}
