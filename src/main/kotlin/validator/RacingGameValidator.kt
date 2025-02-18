package validator

import constant.ErrorConstant

class RacingGameValidator {
    fun validateName(name: List<String>) {
        if (name.isEmpty()) throw IllegalArgumentException(ErrorConstant.ERROR_NO_NAME)
        if (name.toSet().size != name.size) throw IllegalArgumentException(ErrorConstant.ERROR_SAME_NAME)
    }

    fun validateCount(count: Int?) {
        if (count == null) throw IllegalArgumentException(ErrorConstant.ERROR_NOT_NUMBER)
        if (count <= 0) throw IllegalArgumentException(ErrorConstant.ERROR_UNDER_ZERO)
    }
}
