package racingcar.controller

import racingcar.model.Car
import racingcar.utils.RandomNumber
import racingcar.model.Winner
import racingcar.view.InputView
import racingcar.view.OutputView

class Race {
    private val outputView = OutputView()
    private val inputView = InputView()

    private val winner = Winner()
    private var names = listOf<String>()

    private lateinit var cars: List<Car>
    private var roundNumber: Int = INITIAL_ROUND_NUMBER

    fun start() {
        showCarNamesGuide()
        getCars()
        showRoundNumberGuide()
        roundNumber = getRoundNumber()
        showResult(roundNumber)
        showWinners()
    }

    private fun showCarNamesGuide() = outputView.printCarNamesGuide()

    private fun getNames() = inputView.readCarNames()

    private fun getCars(): List<Car> {
        while (true) {
            try {
                names = getNames()
                cars = makeCars()
                break
            } catch (e: IllegalArgumentException) {
                outputView.printErrorMessage(e.message)
            }
        }
        return cars
    }

    private fun makeCars(): List<Car> {
        val cars = mutableListOf<Car>()

        names.forEach { name ->
            cars.add(Car(name))
        }
        return cars
    }

    private fun showRoundNumberGuide() = outputView.printRoundNumberGuide()

    private fun getRoundNumberInput() = inputView.readRoundNumber()

    private fun getRoundNumber(): Int {
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
            val randomNumber = RandomNumber.generator()

            car.move()
            outputView.printRaceResult(car.name, car.position)
        }
    }

    private fun getWinners(cars: List<Car>): List<String> {
        val winners = mutableListOf<String>()
        val maxPosition = getMaxPosition(cars)

        cars.forEach { car ->
            val winner = winner.judge(car, maxPosition)
            if (winner != null) {
                winners.add(winner)
            }
        }
        return winners
    }

    private fun getMaxPosition(cars: List<Car>) = cars.maxOfOrNull { it.position } ?: 0

    private fun showWinners() {
        val winners = getWinners(cars)
        outputView.printWinner(winners)
    }

    companion object {
        const val ERROR_REQUEST_INPUT = "[Error] 값을 입력해 주세요"

        const val INITIAL_ROUND_NUMBER = 0
    }
}
