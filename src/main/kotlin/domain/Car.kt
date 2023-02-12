package domain

import common.ERROR_MESSAGE_FORMAT

class Car(val name: String, private val movingStrategy: MovingStrategy) {

    init {
        require(name.matches(Regex("[a-zA-Z가-힣]{1,5}"))) { ERROR_MESSAGE_FORMAT.format(CAR_NAME_REGEX_ERROR) }
    }

    var advanceCount: Int = 0
        private set

    fun moveAccordingToStrategy() {
        if (movingStrategy.isMovable()) advanceCount++
    }

    override fun equals(other: Any?): Boolean = if (other is Car) this.name == other.name else false
    override fun hashCode(): Int = name.hashCode()
}

private const val CAR_NAME_REGEX_ERROR = "자동차의 이름은 한글 혹은 영어로 공백이 없어야 하며 최소 1글자에서 최대 5글자까지 가능합니다."
