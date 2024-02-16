package racingcar.model

class TryCount(private val count: Int) {
    fun forEach(action: () -> Unit) = repeat(count) { action() }
}
