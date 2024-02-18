package racingcar.model

import racingcar.view.InputView
import racingcar.view.OutputView

class RacingCarRun {
    private val inputView = InputView()
    private val outputView = OutputView()
    private lateinit var carNamesList: List<String>

    fun run() {
        while (true) {
            try {
                carNamesList = inputView.askCarNames()
                break
            } catch (e: IllegalArgumentException) {
                println(NAME_FORMAT_ERROR)
                println(NUMBER_OF_CAR_ERROR)
                println(DUPLICATED_CAR_NAME_ERROR)
            }
        }
        val car: MutableList<Car> = mutableListOf()
        carNamesList.forEach { carName ->
            car.add(Car(carName))
        }

        val numberOfAttempts = inputNumberOfAttempts()
        inputView.printExecutionResults()
        printEachCarsPosition(numberOfAttempts, car, RandomNumberGenerator)
        printFinalWinner(car)
    }

    private fun printFinalWinner(cars: MutableList<Car>) {
        inputView.printLastWinner()
        val finalWinners = FinalWinner.decideWinner(cars)
        outputView.printFinalWinners(finalWinners)
    }

    private fun inputNumberOfAttempts(): Int {
        inputView.enterNumberOfAttempts()
        val numberOfAttempts = validateNumberOfAttempts()
        return numberOfAttempts
    }

    private fun printEachCarsPosition(
        numberOfAttempts: Int,
        cars: MutableList<Car>,
        randomNumberGenerator: RandomNumberGenerator
    ) {
        repeat(numberOfAttempts) {
            cars.forEach { car ->
                val randomNumber = randomNumberGenerator.generateRandomNumber()
                car.moveCar(randomNumber)
            }
            cars.forEach {
                println("${it.name}: ${it.position}")
            }
            println()
        }
    }

    private fun validateNumberOfAttempts(): Int {
        var numberOfAttempts = inputView.askNumberOfAttempts()
        while (true) {
            try {
                inputView.limitNumberOfAttempts(numberOfAttempts)
                break
            } catch (ex: IllegalArgumentException) {
                numberOfAttempts = inputView.askNumberOfAttempts()
                println(NUMBER_OF_ATTEMPTS_ERROR)
            }
        }
        return numberOfAttempts
    }

    companion object {
        const val NUMBER_OF_ATTEMPTS_ERROR = "시도 횟수는 1 ~ 10000여야 합니다."
        const val NAME_FORMAT_ERROR = "이름은 알파벳과 한글로만 이루어져 있어야 합니다."
        const val NUMBER_OF_CAR_ERROR = "차의 갯수는 1 ~ 100여야 합니다."
        const val DUPLICATED_CAR_NAME_ERROR = "차 이름은 중복이 있으면 안 됩니다."
    }
}
