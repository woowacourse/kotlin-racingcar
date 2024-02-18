package racingcar.model

import racingcar.util.Validation

class Car(val name: String) {
    var position: Int = DEFAULT_POSITION
        private set

    init {
        Validation.checkNameLength(name)
    }

    fun move(distance: Int) {
        position += distance
    }

    companion object {
        const val DEFAULT_POSITION = 0
    }
}
