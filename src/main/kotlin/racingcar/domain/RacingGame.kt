package racingcar.domain

import racingcar.constant.STANDARD_MOVING
import racingcar.domain.numbergenerator.RandomNumberGenerator
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingGame(
    private val inputView: InputView,
    private val outputView: OutputView,
    private val generator: RandomNumberGenerator,
) {
    fun runGame() {
        val names = getCarsName()
        val movingCount = getMovingCount()
        val cars = mutableListOf<RacingCar>()
        names.forEach { cars.add(RacingCar(it)) }

        outputView.printResult()
        for (i in 0 until movingCount) {
            playRound(cars)
        }

        outputView.printWinner(getWinner(cars))
    }

    fun getWinner(cars: List<RacingCar>): List<String> {
        val sortedCars = cars.sortedByDescending {
            it.getMovingState()
        }
        val maxState = sortedCars[0].getMovingState()

        return sortedCars.filter {
            it.getMovingState() == maxState
        }.map {
            it.getName()
        }
    }

    fun playRound(cars: MutableList<RacingCar>) {
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

    fun getCarsName(): List<String> {
        outputView.printGettingCarsName()
        return inputView.getCarsName()
    }

    fun getMovingCount(): Int {
        outputView.printGettingMovingCount()
        return inputView.getMovingCount()
    }

    fun checkGoingForward(randomNumber: Int): Boolean = randomNumber >= STANDARD_MOVING
}
