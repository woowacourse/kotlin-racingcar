package racingcar.controller

import racingcar.model.Car
import racingcar.model.RaceManager
import racingcar.view.OutputView

class Race {
    private val outputView = OutputView()
    private val raceManager = RaceManager()

    private lateinit var cars: List<Car>
    private var roundNumber: Int = INITIAL_ROUND_NUMBER

    fun start() {
        raceManager.apply {
            showCarNamesGuide()
            getCars()
            showRoundNumberGuide()
            roundNumber = getRoundNumber()
        }
        showResult(roundNumber)
        showWinners()
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
