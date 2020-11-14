package racingcar.domain

private const val MIN_COUNT = 1

data class TryCount(private var count: Int) {
    init {
        require(count >= MIN_COUNT)
    }

    val isPresent
        get() = count >= MIN_COUNT

    fun minus() = count--
}
