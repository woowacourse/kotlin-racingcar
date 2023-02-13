package racingcar.domain

import racingcar.constant.ERROR_CARS_CREATE

class Cars(names: List<String>) {
    private lateinit var _value: List<RacingCar>
    val value: List<RacingCar> get() = _value

    init {
        check(!names.isNullOrEmpty()) { ERROR_CARS_CREATE }
        names.forEach { initCars(it) }
    }

    private fun initCars(name: String) {
        if (::_value.isInitialized) {
            _value += RacingCar(name)
        } else {
            _value = listOf(RacingCar(name))
        }
    }
}
