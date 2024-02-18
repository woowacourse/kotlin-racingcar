package racingcar.controller

import racingcar.model.Car
import racingcar.model.FinalWinner
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingCarRun {
    private val inputView = InputView()
    private val outputView = OutputView()
    private lateinit var carNamesList: List<String>
    private var numberOfAttempts: Int = 0

    fun run() {
        val car: MutableList<Car> = organizeAndValidateCarList()
        validateNumberOfAttempts()
        outputView.printEachCarsPosition(numberOfAttempts, car)
        printFinalWinner(car)
    }

    private fun validateNumberOfAttempts() {
        while (true) {
            try {
                numberOfAttempts = inputView.askNumberOfAttempts()
                break
            } catch (e: IllegalArgumentException) {
                println(NUMBER_OF_ATTEMPTS_ERROR)
            }
        }
    }

    private fun organizeAndValidateCarList(): MutableList<Car> {
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
        return car
    }

    private fun printFinalWinner(cars: MutableList<Car>) {
        val finalWinners = FinalWinner.decideWinner(cars)
        outputView.printFinalWinners(finalWinners)
    }


    companion object {
        const val NUMBER_OF_ATTEMPTS_ERROR = "시도 횟수는 1 ~ 10000여야 합니다."
        const val NAME_FORMAT_ERROR = "이름은 알파벳과 한글로만 이루어져 있어야 합니다."
        const val NUMBER_OF_CAR_ERROR = "차의 갯수는 1 ~ 100여야 합니다."
        const val DUPLICATED_CAR_NAME_ERROR = "차 이름은 중복이 있으면 안 됩니다."
    }
}
