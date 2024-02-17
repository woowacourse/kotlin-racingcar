package racingcar.view.input

import racingcar.constants.GameConstants
import racingcar.model.Car
import racingcar.model.TryCount

object InputConverter {
    fun convertCars(inputCarNames: String) =
        inputCarNames
            .split(GameConstants.SPLIT_DELIMITER)
            .map { Car(it) }

    fun convertTryCount(inputTryCount: String) = TryCount(inputTryCount.toInt())
}
