package racingCar.domain

data class Name(private val name: String) {
    init {
        if (name.isEmpty() || name.length > 5) {
            throw IllegalArgumentException()
        }
    }
}
