package racingcar.domain

import racingcar.constant.STANDARD_MOVING
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingGame(
    private val inputView: InputView,
    private val outputView: OutputView,
) {
    fun runGame() {
        val names = getCarsName()
        val movingCount = getMovingCount()
        val cars = mutableListOf<RacingCar>()
        names.forEach { cars.add(RacingCar(it)) }

        for (i in 0 until movingCount) {
            playRound(cars)
        }
    }

    fun playRound(cars: MutableList<RacingCar>) {
        // TODO: 자동차 경주
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
