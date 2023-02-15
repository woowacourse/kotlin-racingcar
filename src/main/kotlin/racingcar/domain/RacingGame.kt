package racingcar.domain

import racingcar.domain.MovingDiscriminator.checkGoingForward
import racingcar.domain.numbergenerator.NumberGenerator
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingGame(
    private val generator: NumberGenerator,
    private val referee: Referee,
) {
    fun runGame() {
        val names = getCarsName()
        val roundCount = getRoundCount()
        val cars = Cars.from(names)

        OutputView.printResult()
        for (i in 0 until roundCount) {
            playRound(cars.value)
        }

        OutputView.printWinner(referee.getWinner(cars.value))
    }

    fun playRound(cars: List<RacingCar>) {
        cars.forEach {
            play(it)
        }
        OutputView.printEachRound(cars)
    }

    fun play(car: RacingCar) {
        if (checkGoingForward(generator.generate())) {
            car.moveForward()
        }
    }

    fun getCarsName(): List<String> {
        return InputView.getCarsName { OutputView.printGettingCarsName() }
    }

    fun getRoundCount(): Int {
        return InputView.getRoundCount { OutputView.printGettingRoundCount() }
    }
}
