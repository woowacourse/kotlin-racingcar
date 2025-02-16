package dto

import constant.ErrorConstant

data class TryCount(val input: String) {
    var tryCountNumber: Int = 0

    init {
        tryCountNumber = input.toIntOrNull() ?: throw IllegalArgumentException(ErrorConstant.ERROR_NOT_NUMBER)
        if (tryCountNumber <= 0) throw IllegalArgumentException(ErrorConstant.ERROR_UNDER_ZERO)
    }
}
