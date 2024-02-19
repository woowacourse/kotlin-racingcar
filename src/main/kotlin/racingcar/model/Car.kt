package racingcar.model

import racingcar.constants.Constants.DEFAULT_POSITION

data class Car(
    val name: String,
    private var _position: Int = DEFAULT_POSITION
) {
    val position: Int
        get() = _position

    fun move() {
        _position++
    }
}
