package racingcar.domain

import racingcar.resources.ERROR_MESSAGE_PREFIX

class Car(val name: String) {
    var location = 0
        private set

    init {
        require(name.length in MIN_NAME_LENGTH..MAX_NAME_LENGTH) { ERROR_NAME_LENGTH_RANGE }
    }

    fun move(condition: Int) {
        require(condition in MIN_BOUNDARY..MAX_BOUNDARY) { ERROR_INPUT_COUNT }
        if (condition >= STANDARD_BOUNDARY) {
            this.location++
        }
    }

    companion object {
        private const val MIN_NAME_LENGTH = 1
        private const val MAX_NAME_LENGTH = 5
        const val MIN_BOUNDARY = 0
        const val MAX_BOUNDARY = 9
        private const val STANDARD_BOUNDARY = 4

        private const val ERROR_INPUT_COUNT = ERROR_MESSAGE_PREFIX + "숫자는 0부터 9까지만 입력할 수 있습니다."
        private const val ERROR_NAME_LENGTH_RANGE = ERROR_MESSAGE_PREFIX + "자동차 이름은 1~5자 사이어야 합니다."
    }
}
