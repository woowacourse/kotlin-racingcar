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
        var roundNumber : String

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

    companion object {
        const val COMMA = ","
    }
}