package racingCar.domain

data class Count(private val count: Int) {
    init {
        if (count <= 0) {
            throw IllegalArgumentException()
        }
    }
}
