package racingcar.view

import racingcar.dto.car.CarDto
import racingcar.dto.car.CarsDto
import racingcar.model.round.RoundDto
import racingcar.utils.removeBlank

class InputView {
    fun readCarNames(): CarsDto = CarsDto(
        readln()
            .split(CAR_NAME_DELIMITER)
            .removeBlank()
            .map { carName ->
                CarDto(carName)
            }
    )

    fun readRound(): RoundDto {
        val number = readln().toIntOrNull()
        requireNotNull(number) { NOT_NUMERIC_ERROR_MESSAGE }

        return RoundDto(number)
    }

    companion object {
        private const val CAR_NAME_DELIMITER = ","
        private const val NOT_NUMERIC_ERROR_MESSAGE = "입력값이 숫자가 아닙니다."
    }
}
