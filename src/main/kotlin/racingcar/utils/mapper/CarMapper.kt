package racingcar.utils.mapper

import racingcar.dto.car.CarDto
import racingcar.model.car.Car

fun CarDto.toModel(): Car = Car(carName.value, position)

fun Car.toDto(): CarDto = CarDto(carName.value, position)
