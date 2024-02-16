package racingcar.controller

import racingcar.view.InputView
import racingcar.view.OutputView

class RacingCarRun {
    private val inputView = InputView()
    private val outputView = OutputView()
    private val finalWinner = FinalWinner()

    fun run() {
        inputView.printEnterCarNames()
        val cars: MutableList<Car> = mutableListOf()
        val commaSeparatedListBuilder = CommaSeparatedListBuilder()

        var carNames = inputView.askCarNames()
        var nameOfCars = commaSeparatedListBuilder.commaSeparatedListBuild(carNames)
        var numberOfCars = nameOfCars.size
        repeat(numberOfCars) {
            cars.add(Car(nameOfCars[it]))
        }
        while (true) {
            try {
                inputView.duplicatedCarName(nameOfCars)
                inputView.nameFormat(carNames)
                inputView.limitNumberOfCars(numberOfCars)
                break
            } catch (e: IllegalArgumentException) {
                if (nameOfCars.size != nameOfCars.toSet().size) {
                    println(DUPLICATED_CAR_NAME_ERROR)
                }
                if (numberOfCars !in 1..100) {
                    println(NUMBER_OF_CAR_ERROR)
                }
                if (!Regex("^[a-zA-Z가-힣,]+\$").matches(carNames)){
                    println(NAME_FORMAT_ERROR)
                }
                carNames = inputView.askCarNames()
                nameOfCars = commaSeparatedListBuilder.commaSeparatedListBuild(carNames)
                numberOfCars = nameOfCars.size
                cars.clear()
                repeat(numberOfCars) {
                    cars.add(Car(nameOfCars[it]))
                }
            }
        }
        inputView.enterNumberOfAttempts()
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
        inputView.printExecutionResults()
        val randomNumberGenerator = RandomNumberGenerator()

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
        inputView.printLastWinner()
        val finalWinners = finalWinner.decideWinner(cars)
        outputView.printFinalWinners(finalWinners)
    }

    companion object {
        const val NUMBER_OF_ATTEMPTS_ERROR = "시도 횟수는 1 ~ 10000여야 합니다."
        const val NAME_FORMAT_ERROR = "이름은 알파벳과 한글로만 이루어져 있어야 합니다."
        const val NUMBER_OF_CAR_ERROR = "차의 갯수는 1 ~ 100여야 합니다."
        const val DUPLICATED_CAR_NAME_ERROR = "차 이름은 중복이 있으면 안 됩니다."
    }
}
