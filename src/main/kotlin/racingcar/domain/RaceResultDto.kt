package racingcar.racingcar.domain

import racingcar.domain.Car

data class RaceResultDto(
    val names: List<String>,
    val result: List<List<Int>>,
    val cars: List<Car>
)
