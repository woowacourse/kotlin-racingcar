package racingcar.utils

import racingcar.utils.Constants.CARNAME_ERROR_MESSAGE
import racingcar.utils.Constants.CARNAME_MAX_LENGTH
import racingcar.utils.Constants.COMMA
import racingcar.utils.Constants.TRYCOUNT_ERROR_MESSAGE

object Validate {
    fun String.validCarName(): String {
        val carNames = this.split(COMMA)
        if (carNames.duplicateCarNames() ||
            carNames.emptyCarNames() ||
            carNames.carNameLength()
        ) {
            throw IllegalArgumentException(CARNAME_ERROR_MESSAGE)
        }
        return this
    }

    fun String.validTryCount(): String {
        if (this.toIntTryCount() || this.emptyTryCount()) throw IllegalArgumentException(TRYCOUNT_ERROR_MESSAGE)
        return this
    }

    private fun List<String>.duplicateCarNames(): Boolean {
        return this.size != this.toSet().size
    }

    private fun List<String>.emptyCarNames(): Boolean {
        this.forEach { carName ->
            return carName.isBlank()
        }
        return false
    }

    private fun List<String>.carNameLength(): Boolean {
        this.forEach { carName ->
            return carName.length > CARNAME_MAX_LENGTH
        }
        return false
    }

    private fun String.toIntTryCount(): Boolean {
        return this.toIntOrNull() == null
    }

    private fun String.emptyTryCount(): Boolean {
        return this.isBlank()
    }
}
