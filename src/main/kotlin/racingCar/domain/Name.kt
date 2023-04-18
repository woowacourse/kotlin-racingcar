package racingCar.domain

data class Name(val name: String) {
    init {
        if (name.isEmpty() || name.length > 5) {
            throw IllegalArgumentException()
        }
    }
}
