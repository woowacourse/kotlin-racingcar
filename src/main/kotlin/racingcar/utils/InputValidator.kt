package racingcar.utils

import racingcar.constants.Constants.DUPLICATED_NAME_EXCEPTION
import racingcar.constants.Constants.INVALID_NAME_SIZE_EXCEPTION
import racingcar.constants.Constants.INVALID_NUM_OF_CARS_EXCEPTION
import racingcar.constants.Constants.INVALID_TRIAL_NUM_RANGE_EXCEPTION
import racingcar.constants.Constants.INVALID_TRIAL_NUM_TYPE_EXCEPTION

object InputValidator {
    fun getValidatedNames(input: String): List<String> {
        val names = input.split(NAME_SEPARATOR).map { it.trim() }
        if (names.size < MINIMUM_NAME_THRESHOLD) throw IllegalArgumentException(INVALID_NUM_OF_CARS_EXCEPTION)
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
    private const val MINIMUM_NAME_THRESHOLD = 2
    private const val MAXIMUM_NAME_LENGTH_THRESHOLD = 5
    private const val MINIMUM_TRIAL_NUM_THRESHOLD = 1
}