package racingcar.domain

import racingcar.constant.ERROR_CARS_CREATE

class Cars(names: List<RacingCar>) {
    private var _value: List<RacingCar> = names
    val value: List<RacingCar> get() = _value

    companion object {
        fun from(names: List<String>): Cars {
            check(!names.isNullOrEmpty()) { ERROR_CARS_CREATE }
            return Cars(names.map { RacingCar(it) })
        }
    }
}
