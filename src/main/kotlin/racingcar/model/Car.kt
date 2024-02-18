package racingcar.model

class Car(var name: String, var position: Int = DEFAULT_POSITION) {
    init {
        require(name.length <= CAR_NAME_LENGTH_MAX)
    }

    fun move(distance: Int) {
        position += distance
    }

    companion object {
        const val CAR_NAME_LENGTH_MAX = 5
        const val DEFAULT_POSITION = 0
    }
}
