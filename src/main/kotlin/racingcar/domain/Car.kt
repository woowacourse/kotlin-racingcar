package racingcar.domain

private const val EMPTY_NAME_ERROR_MESSAGE = "이름을 입력하지 않았습니다. 재입력해주세요."
private const val MAX_NAME_LENGTH_ERROR_MESSAGE = "이름을 5글자 이하로 입력해주세요."
private const val MAX_LENGTH = 5
private var PROCEED_FLAG_NUMBER = 4

data class Car(val name: String, var position: Int = 0) {

    init {
        validateCarName(name)
    }

    fun proceed(number: Int) {
        if (number >= PROCEED_FLAG_NUMBER) {
            position++
        }
    }
}

fun validateCarName(name: String) {
    require(!isEmptyName(name)) { EMPTY_NAME_ERROR_MESSAGE }
    require(!isIllegalLength(name)) { MAX_NAME_LENGTH_ERROR_MESSAGE }
}

fun isEmptyName(name: String): Boolean {
    return name.isNullOrBlank()
}

fun isIllegalLength(name: String): Boolean {
    return name.length > MAX_LENGTH
}
