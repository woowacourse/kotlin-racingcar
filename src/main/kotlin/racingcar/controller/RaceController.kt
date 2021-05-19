package racingcar.controller

import racingcar.domain.Car
import racingcar.domain.Cars
import racingcar.view.InputView
import racingcar.view.OutputView

class RaceController {

    fun race() {
        val names: List<String> = InputView.inputNames().split(",")
        val namesToCar: ArrayList<Car> = names
            .map { name -> Car(name) }
            .toCollection(arrayListOf())
        val cars = Cars(namesToCar)

        val laps = InputView.inputLaps()

        OutputView.printRaceInitMessage()
        for (i in 0 until laps) {
            cars.race()
            OutputView.printStatus(cars.status())
        }
        OutputView.printWinners(
            cars.winners())
    }
}