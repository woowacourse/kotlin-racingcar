package racingcar.util

fun <T> retryWhenException(
    action: () -> T,
    onError: (String?) -> Unit,
): T {
    while (true) {
        try {
            return action()
        } catch (e: IllegalArgumentException) {
            onError(e.message)
        }
    }
}
