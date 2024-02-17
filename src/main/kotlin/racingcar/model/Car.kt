package racingcar.model

data class Car(val name: String, var distance: Int = DEFAULT_DISTANCE) {
    init {
        require(name.length <= CAR_NAME_LENGTH) { MESSAGE_ERROR_CAR_NAME }
    }

    override fun toString() = "$name : ${"-".repeat(distance)}"

    fun move(step: Int) {
        distance += step
    }

    companion object {
        const val DEFAULT_DISTANCE = 0

        const val CAR_NAME_LENGTH = 5
        const val MESSAGE_ERROR_CAR_NAME = "자동차 이름은 5글자를 초과할 수 없습니다."
    }
}
