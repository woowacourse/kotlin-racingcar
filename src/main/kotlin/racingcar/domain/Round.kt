package racingcar.domain

class Round(
    private var value: Int
) {
    init {
        if (value < 1) {
            throw IllegalArgumentException("시도횟수는 1회이상이어야 합니다.")
        }
    }

    fun isGoing(): Boolean {
        return value > 0
    }

    fun decrease() {
        value -= 1
    }
}
