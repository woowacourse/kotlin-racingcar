package data

import constant.ErrorConstant

data class Car(
    val name: String,
    val currentPosition: Int = 0
) {
    init {
        require(name.length <= 5) { ErrorConstant.ERROR_WRONG_NAME_LENGTH }
    }
}