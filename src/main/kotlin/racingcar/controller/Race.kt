package racingcar.controller

import racingcar.model.Car
import racingcar.model.RaceManager
import racingcar.view.InputView
import racingcar.view.OutputView

class Race {
    private val outputView = OutputView()
    private val inputView = InputView()
    private val raceManager = RaceManager()

    private lateinit var cars: List<Car>
    private var roundNumber: Int = INITIAL_ROUND_NUMBER

    fun start() {
        showCarNamesGuide()
        getCars()
        raceManager.apply {
            showRoundNumberGuide()
            roundNumber = getRoundNumber()
        }
        showResult(roundNumber)
        showWinners()
    }

    private fun showCarNamesGuide() = outputView.printCarNamesGuide()

    private fun getNames(): String = inputView.readCarNames()

    private fun splitNames(): List<String> = getNames().split(COMMA)

    fun validateNames(names: List<String>) {
        require(names.isNotEmpty()) { ERROR_REQUEST_INPUT }
        require(names.size >= MIN_NAMES_SIZE) { ERROR_CAR_LESS_THAN_TWO }
        require(names.size <= MAX_NAMES_SIZE) { ERROR_CAR_GREATER_THAN_TWENTY }
        require(names.distinct().size == names.size) { ERROR_NAME_DUPLICATION }
    }

    private fun makeCars(): List<Car> {
        val names = splitNames()
        val cars = mutableListOf<Car>()

        validateNames(names)
        names.forEach { name ->
            cars.add(Car(name))
        }
        return cars
    }

    private fun getCars() {
        while (true) {
            try {
                cars = makeCars()
                break
            } catch (e: IllegalArgumentException) {
                outputView.printErrorMessage(e.message)
            }
        }
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
        const val ERROR_CAR_LESS_THAN_TWO = "[Error] 자동차 이름은 2대 이상 입력해 주세요."
        const val ERROR_CAR_GREATER_THAN_TWENTY = "[Error] 자동차 이름은 20대 이하로 입력해 주세요."
        const val ERROR_NAME_DUPLICATION = "[Error] 중복된 자동차 이름은 작성할 수 없습니다."

        const val COMMA = ","

        const val MIN_NAMES_SIZE = 2
        const val MAX_NAMES_SIZE = 20
        const val INITIAL_ROUND_NUMBER = 0
    }
}
