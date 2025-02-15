package racingcar

class Car(
    val name: String,
    initialDistance: Int = 0,
) {
    init {
        runCatching {
            require(name.length in MIN_NAME_LENGTH..MAX_NAME_LENGTH)
        }.onFailure {
            println("자동차 이름은 5자를 초과할 수 없습니다. 다시 입력해주세요.")
            Input().readCars()
        }
    }

    var distance: Int = initialDistance
        private set

    fun move() {
        distance += 1
    }

    companion object {
        const val MIN_NAME_LENGTH = 1
        const val MAX_NAME_LENGTH = 5
        const val DISTANCE_SYMBOL: String = "-"
    }
}
