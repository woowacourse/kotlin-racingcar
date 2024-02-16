package racingcar.controller

import racingcar.model.Car
import racingcar.view.InputView
import racingcar.view.OutputView

class Race {
    private val outputView = OutputView()
    private val inputView = InputView()
    private lateinit var cars: List<Car>
    private var roundNumber: Int = INITIAL_ROUND_NUMBER

    fun start() {
        showCarNamesGuide()
        getCars()
        roundNumber = getRoundNumber()
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
                println(e.message)
            }
        }
    }

    private fun getRoundNumber(): Int {
        outputView.printRoundNumberGuide()
        var roundNumber: Int

        while (true) {
            try {
                val roundNumberInput = inputView.readRoundNumber()

                roundNumber = getValidRoundNumber(roundNumberInput)
                break
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }

        return roundNumber
    }

    fun getValidRoundNumber(roundNumberInput: String): Int {
        require(checkRoundNumber(roundNumberInput)) { ERROR_INPUT_NUMBER_ONLY }
        require(roundNumberInput.isNotEmpty()) { ERROR_REQUEST_INPUT }

        val roundNumber = roundNumberInput.toInt()
        require(roundNumber >= MIN_ROUND_NUMBER) { ERROR_ROUND_LESS_THAN_ONE }

        return roundNumber
    }

    fun checkRoundNumber(roundNumber: String): Boolean {
        try {
            roundNumber.toInt()
            return true
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(ERROR_INPUT_NUMBER_ONLY)
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
        const val ERROR_ROUND_LESS_THAN_ONE = "[Error] 1회 이상 입력해 주세요."
        const val ERROR_INPUT_NUMBER_ONLY = "[Error] 숫자만 입력해 주세요."

        const val COMMA = ","

        const val MIN_NAMES_SIZE = 2
        const val MAX_NAMES_SIZE = 20
        const val MIN_ROUND_NUMBER = 1
        const val INITIAL_ROUND_NUMBER = 0
    }
}
