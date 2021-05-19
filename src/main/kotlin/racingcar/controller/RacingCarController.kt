package racingcar.controller

import racingcar.model.Car
import racingcar.model.Cars
import racingcar.view.InputView

class RacingCarController {

    fun run() {
        val cars = createCars(InputView.inputCarNumber())
        val tryNumber = InputView.inputTryNumber()
        val racingCarGame = RacingCarGame(cars, tryNumber)
        val racingResult = racingCarGame.race()
        OutputView.printResults(racingResult)
    }

    private fun createCars(carNumber: Int): Cars {
        val cars = arrayListOf<Car>()
        for (i in 0 until carNumber) {
            cars.add(Car())
        }
        return Cars(cars)
    }
}
