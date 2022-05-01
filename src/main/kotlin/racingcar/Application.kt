package racingcar

import racingcar.domain.Cars
import racingcar.domain.TryNumber
import racingcar.view.InputView
import racingcar.view.OutputView

fun main() {

    var cars = Cars.from(InputView.inputCarNames())
    val tryNumber = TryNumber(InputView.inputTryNumber())

    OutputView.printIntroduction()
    while (!tryNumber.isGameOver()) {
        tryNumber.decrease()
        cars = cars.move()
        OutputView.printProcess(cars.cars)
    }

    OutputView.printWinners(cars.findWinners())
}
