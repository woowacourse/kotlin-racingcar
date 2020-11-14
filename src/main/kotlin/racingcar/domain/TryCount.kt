package racingcar.domain

private const val MIN_COUNT = 1

class TryCount(val count: Int) {
    init {
        require(count >= MIN_COUNT)
    }
}
