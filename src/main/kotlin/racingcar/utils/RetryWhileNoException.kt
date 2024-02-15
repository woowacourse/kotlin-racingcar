package racingcar.utils

import racingcar.constants.ErrorConstants

fun <T> retryWhileNoException(action: () -> T): T {
    while (true) {
        try {
            return action()
        } catch (e: IllegalArgumentException) {
            println(ErrorConstants.ERROR_PREFIX + e.localizedMessage)
        }
    }
}
