package racingcar.domain

import racingcar.constant.ERROR_CARS_CREATE

class Cars(val value: List<RacingCar>) {

    companion object {
        fun from(names: List<String>): Cars {
            check(!names.isNullOrEmpty()) { ERROR_CARS_CREATE }
            return Cars(names.map { RacingCar(it) })
        }
    }
}
