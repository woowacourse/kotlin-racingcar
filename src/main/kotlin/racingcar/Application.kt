package racingcar

import racingcar.domain.Cars
import racingcar.domain.Round
import racingcar.view.InputView
import racingcar.view.OutputView

fun main() {

    val cars = Cars.from(InputView.inputCarNames())
    val round = Round(InputView.inputRound())

    while (round.isGoing()) {
        cars.moveAll()
        round.decrease()
    }

    OutputView.showWinners(cars.findWinners())
}
