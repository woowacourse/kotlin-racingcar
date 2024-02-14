package racingcar.controller

import racingcar.model.Car
import racingcar.model.Messages
import racingcar.view.InputView
import racingcar.view.OutputView

class Run {

    private val inputView = InputView()
    private val outputView = OutputView()
    private val moveOrStay = MoveOrStay()
    private val finalWinner = FinalWinner()

    fun run() {
        outputView.printEnterCarNames()
        val carNames = inputView.askCarNames()
        val commaSeparatedListBuilder = CommaSeparatedListBuilder(carNames)
        val nameOfCars = commaSeparatedListBuilder.commaSeparatedListBuild()
        val numberOfCars = nameOfCars.size
        val cars: MutableList<Car> = mutableListOf()

        repeat(numberOfCars) {
            cars.add(Car(nameOfCars[it]))
        }

        outputView.enterNumberOfAttempts()
        val numberOfAttempts = inputView.askNumberOfAttempts()

        outputView.printExecutionResults()

        val randomNumberGenerator = RandomNumberGenerator(numberOfCars)

        repeat(numberOfAttempts) {
            val randomNumbers = randomNumberGenerator.putRandomNumbers()
            cars.forEachIndexed { index, car ->
                if(moveOrStay.decideMovement(randomNumbers[index])){
                    car.position += Messages.DASH
                }
            }
            cars.forEach {
                println("${it.name}: ${it.position}")
            }
            println()
        }
        outputView.printLastWinner()
        val finalWinners = finalWinner.decideWinner(cars)
        print(finalWinners.joinToString(", "))
    }
}