package model

class Car(val name: String, forwardCount: Int = DEFAULT_FORWARD_COUNT) {

    var forwardCount = forwardCount
        private set

    init {
        checkNameLength(name)
    }

    fun moveForward(isMove: Boolean) {
        if (isMove) {
            forwardCount++
        }
    }

    companion object {
        private const val DEFAULT_FORWARD_COUNT = 0
        private const val CAR_NAME_MIN_LENGTH = 1
        private const val CAR_NAME_MAX_LENGTH = 5

        fun checkNameLength(carName: String) {
            require(carName.length in CAR_NAME_MIN_LENGTH..CAR_NAME_MAX_LENGTH) { "[ERROR] 자동차 이름은 5자 이하여야 합니다." }
        }
    }
}
