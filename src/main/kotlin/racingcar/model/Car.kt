package racingcar.model

class Car(val name: String) {
    var position: Int = DEFAULT_POSITION
        private set

    init {
        require(name.length <= CAR_NAME_MAX_LENGTH)
    }

    fun move(distance: Int) {
        position += distance
    }

    companion object {
        const val DEFAULT_POSITION = 0
        const val CAR_NAME_MAX_LENGTH = 5
    }
}
