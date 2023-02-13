package racingcar.utils.mapper

import racingcar.dto.car.CarDto
import racingcar.model.car.Car

fun CarDto.toModel(): Car = Car(carName.name, position)

fun Car.toDto(): CarDto = CarDto(carName.name)
