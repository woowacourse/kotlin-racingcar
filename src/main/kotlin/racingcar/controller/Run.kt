package racingcar.controller

import racingcar.model.Car
import racingcar.model.Settings
import racingcar.view.InputView
import racingcar.view.OutputView

class Run {
    private val inputView = InputView()
    private val outputView = OutputView()
    private val moveOrStay = MoveOrStay()
    private val finalWinner = FinalWinner()
    private val exceptionHandling = ExceptionHandling()

    fun run() {
        outputView.printEnterCarNames()
        var carNames = inputView.askCarNames()
        val cars: MutableList<Car> = mutableListOf()
        val commaSeparatedListBuilder = CommaSeparatedListBuilder()
        var nameOfCars = commaSeparatedListBuilder.commaSeparatedListBuild(carNames)
        val numberOfCars = nameOfCars.size

        initCars(numberOfCars, cars, nameOfCars)

        while (!(exceptionHandling.nameFormat(carNames) && exceptionHandling.limitNumberOfCars(
                numberOfCars
            ) && exceptionHandling.duplicatedCarName(nameOfCars))
        ) {
            carNames = inputView.askCarNames()
            nameOfCars = commaSeparatedListBuilder.commaSeparatedListBuild(carNames)
        }

        outputView.enterNumberOfAttempts()
        var numberOfAttempts = inputView.askNumberOfAttempts()

        while (!exceptionHandling.limitNumberOfAttempts(numberOfAttempts)) {
            numberOfAttempts = inputView.askNumberOfAttempts()
        }

        outputView.printExecutionResults()

        val randomNumberGenerator = RandomNumberGenerator(numberOfCars)

        repeat(numberOfAttempts) {
            progressCarPosition(randomNumberGenerator, cars)
            cars.forEach {
                println("${it.name}: ${it.position}")
            }
            println()
        }
        outputView.printLastWinner()
        val finalWinners = finalWinner.decideWinner(cars)
        print(finalWinners.joinToString(Settings.FINAL_WINNER_PRINT_SEPARATOR))
    }

    private fun initCars(
        numberOfCars: Int,
        cars: MutableList<Car>,
        nameOfCars: List<String>
    ) {
        repeat(numberOfCars) {
            cars.add(Car(nameOfCars[it]))
        }
    }

    private fun progressCarPosition(
        randomNumberGenerator: RandomNumberGenerator,
        cars: MutableList<Car>
    ) {
        val randomNumbers = randomNumberGenerator.putRandomNumbers()
        cars.forEachIndexed { index, car ->
            if (moveOrStay.decideMovement(randomNumbers[index])) {
                car.position += Settings.PROGRESS
            }
        }
    }
}