package racingcar.utils

import racingcar.constants.Constants.DUPLICATED_NAME_EXCEPTION
import racingcar.constants.Constants.INVALID_NAME_SIZE_EXCEPTION
import racingcar.constants.Constants.INVALID_NUM_OF_CARS_EXCEPTION
import racingcar.constants.Constants.INVALID_TRIAL_NUM_RANGE_EXCEPTION
import racingcar.constants.Constants.INVALID_TRIAL_NUM_TYPE_EXCEPTION
import racingcar.constants.Constants.MAXIMUM_NAME_LENGTH
import racingcar.constants.Constants.MINIMUM_CARS_NUMBER
import racingcar.constants.Constants.MINIMUM_TRIAL_NUM

object InputValidator {
    fun getValidatedNames(input: String): List<String> {
        val names = input.split(NAME_SEPARATOR).map { it.trim() }
        if (names.size < MINIMUM_CARS_NUMBER) {
            throw IllegalArgumentException(
                INVALID_NUM_OF_CARS_EXCEPTION
            )
        }
        require(names.all { name -> name.isNotEmpty() && name.length <= MAXIMUM_NAME_LENGTH }) {
            INVALID_NAME_SIZE_EXCEPTION
        }
        if (names.toSet().size != names.size) throw IllegalArgumentException(DUPLICATED_NAME_EXCEPTION)
        return names
    }

    fun getValidatedTrialNum(input: Int): Int {
        require(MINIMUM_TRIAL_NUM < input) { INVALID_TRIAL_NUM_RANGE_EXCEPTION }
        return input
    }

    fun getIntegerOrException(input: String): Int =
        input.toIntOrNull() ?: throw IllegalArgumentException(INVALID_TRIAL_NUM_TYPE_EXCEPTION)

    private const val NAME_SEPARATOR = ","
}
