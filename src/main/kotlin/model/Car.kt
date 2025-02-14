package model

class Car(val name: String) {
    var position: Int = DEFAULT_POSITION
        private set

    init {
        require(name.trim().length in MIN_VALUE..MAX_VALUE) { CAR_NAME_LENGTH_MESSAGE }
    }

    fun tryForward(forward: Int) {
        if (forward >= FORWARD_VALUE) position++
    }

    private companion object {
        const val CAR_NAME_LENGTH_MESSAGE = "자동차 이름의 길이는 최소 1글자 최대 5글자여야 합니다."
        const val DEFAULT_POSITION: Int = 0
        const val FORWARD_VALUE: Int = 4
        const val MAX_VALUE: Int = 5
        const val MIN_VALUE: Int = 1
    }
}
