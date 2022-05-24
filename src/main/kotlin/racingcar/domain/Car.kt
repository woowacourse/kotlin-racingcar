package racingcar.domain

class Car(val name: String) {
    var position = 0
        private set

    init {
        require(name.isNotEmpty()) { "이름은 빈 값일 수 없습니다." }
        require(name.length <= 5) { "이름은 5자 이하로 입력하세요." }
    }

    fun move(x: Int) {
        if (x >= MOVABLE_BOUND) position += 1
    }

    companion object {
        private const val MOVABLE_BOUND = 4
    }
}
