package racingcar.model

class TryCount(private val count: Int) {
    fun forEach(action: () -> Unit) {
        for (idx in 1..count) {
            action()
        }
    }
}
