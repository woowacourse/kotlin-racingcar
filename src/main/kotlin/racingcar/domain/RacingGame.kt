package racingcar.domain

import racingcar.domain.numbergenerator.NumberGenerator
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingGame(
    private val inputView: InputView,
    private val outputView: OutputView,
    private val generator: NumberGenerator,
) {
    fun runGame() {
        val names = getCarsName()
        val roundCount = getRoundCount()
        val cars = mutableListOf<RacingCar>()
        names.forEach { cars.add(RacingCar(it)) }

        outputView.printResult()
        for (i in 0 until roundCount) {
            playRound(cars)
        }

        outputView.printWinner(getWinner(cars))
    }

    fun getWinner(cars: List<RacingCar>): List<String> {
        val sortedCars = cars.sortedByDescending { it.movingState }
        val maxState = sortedCars.maxOf { it.movingState }

        return sortedCars
            .filter { car -> car.movingState == maxState }
            .map { car -> car.name }
    }

    private fun playRound(cars: MutableList<RacingCar>) {
        cars.forEach {
            play(it)
        }
        outputView.printEachRound(cars)
    }

    fun play(car: RacingCar) {
        if (checkGoingForward(generator.generate())) {
            car.moveForward()
        }
    }

    private fun getCarsName(): List<String> {
        return inputView.getCarsName { outputView.printGettingCarsName() }
    }

    private fun getRoundCount(): Int {
        return inputView.getRoundCount { outputView.printGettingRoundCount() }
    }

    fun checkGoingForward(randomNumber: Int): Boolean = randomNumber >= STANDARD_OF_MOVING

    companion object {
        private const val STANDARD_OF_MOVING = 4
    }
}
