package racingcar.utils

import racingcar.constants.Constants.DUPLICATED_NAME_EXCEPTION
import racingcar.constants.Constants.INVALID_NAME_SIZE_EXCEPTION
import racingcar.constants.Constants.INVALID_NUM_OF_CARS_EXCEPTION
import racingcar.constants.Constants.INVALID_TRIAL_NUM_RANGE_EXCEPTION
import racingcar.constants.Constants.INVALID_TRIAL_NUM_TYPE_EXCEPTION
import racingcar.constants.Constants.MAXIMUM_NAME_LENGTH_THRESHOLD
import racingcar.constants.Constants.MINIMUM_NAMES_COUNT_THRESHOLD
import racingcar.constants.Constants.MINIMUM_TRIAL_NUM_THRESHOLD

object InputValidator {
    fun getValidatedNames(input: String): List<String> {
        val names = input.split(NAME_SEPARATOR).map { it.trim() }
        if (names.size < MINIMUM_NAMES_COUNT_THRESHOLD) throw IllegalArgumentException(INVALID_NUM_OF_CARS_EXCEPTION)
        require(names.all { name -> name.isNotEmpty() && name.length <= MAXIMUM_NAME_LENGTH_THRESHOLD }) {
            INVALID_NAME_SIZE_EXCEPTION
        }
        if (names.toSet().size != names.size) throw IllegalArgumentException(DUPLICATED_NAME_EXCEPTION)
        return names
    }

    fun getValidatedTrialNum(input: String): Int = try {
        val trialNum = input.toInt()
        if (trialNum < MINIMUM_TRIAL_NUM_THRESHOLD) throw IllegalArgumentException(INVALID_TRIAL_NUM_RANGE_EXCEPTION)
        trialNum
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException(INVALID_TRIAL_NUM_TYPE_EXCEPTION)
    }

    private const val NAME_SEPARATOR = ","
}