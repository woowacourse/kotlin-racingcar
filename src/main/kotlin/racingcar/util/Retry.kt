package racingcar.util

fun <T> retryWhenException(
    action: () -> T,
    onError: (String?) -> Unit,
): T {
    while (true) {
        runCatching {
            return action()
        }.onFailure {
            onError(it.message)
        }
    }
}
