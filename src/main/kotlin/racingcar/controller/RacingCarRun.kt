package racingcar.controller

import racingcar.model.Car
import racingcar.model.Settings
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingCarRun {
    private val inputView = InputView()
    private val outputView = OutputView()
    private val moveOrStay = MoveOrStay()
    private val finalWinner = FinalWinner()
    private val exceptionHandling = ExceptionHandling()

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
}
