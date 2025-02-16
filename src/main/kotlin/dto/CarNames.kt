package dto

import constant.ErrorConstant

data class CarNames(val input: String) {
    val carNamesList: List<String> = input.split(",").map { it.trim() }.filter { it.isNotBlank() }

    init {
        if (carNamesList.isEmpty()) throw IllegalArgumentException(ErrorConstant.ERROR_NO_NAME)
        if (carNamesList.toSet().size != carNamesList.size) throw IllegalArgumentException(ErrorConstant.ERROR_SAME_NAME)
        if (carNamesList.any { it.length > 5 }) throw IllegalArgumentException(ErrorConstant.ERROR_WRONG_NAME_LENGTH)
    }
}
