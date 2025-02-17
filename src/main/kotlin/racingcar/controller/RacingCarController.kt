package racingcar.controller

import racingcar.domain.Car
import racingcar.domain.RoundManager

class RacingCarController {
    fun parseToCars(carNames: List<String>): List<Car> = carNames.map { carName: String -> Car(carName) }

    fun parseToRoundManager(round: Int): RoundManager = RoundManager(round)
}
