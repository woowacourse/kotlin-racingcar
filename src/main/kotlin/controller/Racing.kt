package controller

import model.car.Car
import model.car.CarFactory
import model.number.RandomNumber
import view.InputView
import view.OutputView

class Racing {
    private val inputView = InputView()
    private val outputView = OutputView()

    fun play() {
        val cars = getCars(inputView.readCars())
        val attempts = inputView.readAttempt()
        race(cars, attempts)
        val winners = getWinners(cars)
        outputView.printRaceWinner(winners)
    }

    private fun getCars(carsInput: String): List<Car> {
        val carsName = carsInput.split(CAR_DELIMITER)
        return duplicateCarName(CarFactory().createCar(carsName))
    }

    private fun duplicateCarName(carsName: List<Car>): List<Car> {
        if (carsName.size != carsName.toSet().size) outputView.printDuplicate()
        return carsName.distinct()
    }

    private fun race(
        cars: List<Car>,
        attempts: Int,
    ) {
        outputView.printResultTitle()
        repeat(attempts) {
            carMove(cars)
        }
    }

    private fun carMove(carsName: List<Car>) {
        carsName.forEach { car ->
            car.move(RandomNumber())
        }
        outputView.printCarState(carsName)
    }

    private fun getWinners(cars: List<Car>): List<Car> {
        val maxPosition = cars.maxOf { car -> car.position }
        return cars.filter { car -> car.position == maxPosition }
    }

    companion object {
        const val CAR_DELIMITER = ","
    }
}
