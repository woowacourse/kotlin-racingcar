package racingcar.domain

data class TryNumber(private var value: Int) {
    constructor(input: String) : this(input.toIntOrNull() ?:
    throw IllegalArgumentException("$input 을 숫자로 변환할 수 없습니다."))

    init {
        require(value > 0) { "이동횟수는 양수여야 합니다." }
    }

    fun decrease() {
        this.value--
    }

    fun isGameOver(): Boolean {
        return this.value <= 0
    }
}
