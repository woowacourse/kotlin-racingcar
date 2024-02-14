package racingcar.utils

import racingcar.constants.Constants.DUPLICATED_NAME_EXCEPTION
import racingcar.constants.Constants.INVALID_NAME_SIZE_EXCEPTION

object InputValidator {
    fun getValidatedNames(nameInput: String): List<String> {
        val names = nameInput.trim().split(NAME_SEPARATOR)

        if (names.size < MINIMUM_NAME_INPUT_THRESHOLD) throw IllegalArgumentException(INVALID_NAME_SIZE_EXCEPTION)
        if (names.toSet().size != names.size) throw IllegalArgumentException(DUPLICATED_NAME_EXCEPTION)
        require(names.all { name -> name.isNotEmpty() && name.length <= MAXIMUM_NAME_INPUT_LENGTH_THRESHOLD}) {
            INVALID_NAME_SIZE_EXCEPTION
        }

        return names
    }
//     catch (e: IllegalArgumentException) {
//        println(e.message)
//    }

    private const val NAME_SEPARATOR = ","
    private const val MINIMUM_NAME_INPUT_THRESHOLD = 2
    private const val MAXIMUM_NAME_INPUT_LENGTH_THRESHOLD = 5
}