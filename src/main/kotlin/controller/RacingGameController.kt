package controller

import model.Car
import view.InputView
import view.OutputView
import java.util.Random

class RacingGameController {
    private val viewController = RacingViewController(InputView(), OutputView())

    fun startRacingGameProgram() {
        val cars: List<Car> = viewController.getCarName().map { Car(it) }
        val count: Int = viewController.getTryCount()
        executeRacing(cars, count)
        val winnerList: List<Car> = getFinalResult(cars)
        viewController.printFinalResult(winnerList)
    }

    private fun executeRacing(
        cars: List<Car>,
        count: Int,
    ) {
        viewController.printGameResult()
        repeat(count) {
            runEachCar(cars)
        }
    }

    private fun runEachCar(cars: List<Car>) {
        for (car in cars) {
            car.moveCar(Random())
        }
        viewController.printCurrentPosition(cars)
    }

    fun getFinalResult(cars: List<Car>): List<Car> {
        val maxPosition = cars.maxOfOrNull { it.currentPosition }
        val winnerList = cars.filter { it.currentPosition == maxPosition }
        return winnerList
    }
}
