package racingcar.model

import racingcar.controller.FinalWinner
import racingcar.controller.RandomNumberGenerator
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
        val carNames = inputView.askCarNames()
        val nameOfCars = commaSeparatedListBuilder.commaSeparatedListBuild(carNames)
        val numberOfCars = nameOfCars.size
        repeat(numberOfCars) { cars.add(Car(nameOfCars[it])) }
        reinputAndOrganizeCarNames(nameOfCars, carNames, numberOfCars, commaSeparatedListBuilder, cars)
        handleCarRaceIO(cars)
    }

    private fun reinputAndOrganizeCarNames(
        nameOfCars: List<String>,
        carNames: String,
        numberOfCars: Int,
        commaSeparatedListBuilder: CommaSeparatedListBuilder,
        cars: MutableList<Car>
    ) {
        var nameOfCars1 = nameOfCars
        var carNames1 = carNames
        var numberOfCars1 = numberOfCars
        while (true) {
            try {
                inputViewValidate(nameOfCars1, carNames1, numberOfCars1)
                break
            } catch (e: IllegalArgumentException) {
                printEachErrorMessages(nameOfCars1, numberOfCars1, carNames1)
                carNames1 = inputView.askCarNames()
                nameOfCars1 = commaSeparatedListBuilder.commaSeparatedListBuild(carNames1)
                numberOfCars1 = nameOfCars1.size
                cars.clear()
                repeat(numberOfCars1) { cars.add(Car(nameOfCars1[it])) }
            }
        }
    }

    private fun inputViewValidate(
        nameOfCars: List<String>,
        carNames: String,
        numberOfCars: Int
    ) {
        inputView.duplicatedCarName(nameOfCars)
        inputView.nameFormat(carNames)
        inputView.limitNumberOfCars(numberOfCars)
    }

    private fun handleCarRaceIO(cars: MutableList<Car>) {
        inputView.enterNumberOfAttempts()
        val numberOfAttempts = validateNumberOfAttempts()
        inputView.printExecutionResults()
        val randomNumberGenerator = RandomNumberGenerator()

        printEachCarsPosition(numberOfAttempts, cars, randomNumberGenerator)
        inputView.printLastWinner()
        val finalWinners = finalWinner.decideWinner(cars)
        outputView.printFinalWinners(finalWinners)
    }

    private fun printEachErrorMessages(
        nameOfCars: List<String>,
        numberOfCars: Int,
        carNames: String
    ) {
        if (nameOfCars.size != nameOfCars.toSet().size) {
            println(DUPLICATED_CAR_NAME_ERROR)
        }
        if (numberOfCars !in 1..100) {
            println(NUMBER_OF_CAR_ERROR)
        }
        if (!Regex("^[a-zA-Z가-힣,]+\$").matches(carNames)) {
            println(NAME_FORMAT_ERROR)
        }
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
