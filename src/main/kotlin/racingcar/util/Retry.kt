package racingcar.util

fun <T> retryWhenException(action: () -> T): T {
    while (true) {
        try {
            return action()
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }
}
