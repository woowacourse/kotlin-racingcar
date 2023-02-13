package racingcar.utils.mapper

import racingcar.dto.car.CarsDto
import racingcar.model.car.Cars

fun CarsDto.toModel(): Cars = Cars(this.map { it.toModel() })

fun Cars.toDto(): CarsDto = CarsDto(
    this.map { car -> car.toDto() }
)
