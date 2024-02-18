package racingcar.view.input

import racingcar.constants.StringConstants
import racingcar.model.Car
import racingcar.model.TryCount

object InputConverter {
    fun convertCars(inputCarNames: String) =
        inputCarNames
            .split(StringConstants.SPLIT_DELIMITER)
            .map { Car(it) }

    fun convertTryCount(inputTryCount: String) = TryCount(inputTryCount.toInt())
}
