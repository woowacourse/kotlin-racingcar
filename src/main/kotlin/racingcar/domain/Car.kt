package racingcar.domain

class Car(val name: String) : Comparable<Car> {

    var position: Int = 0
        private set

    init {
        require(name.isNotBlank()) { "공백을 입력하면 안됩니다." }
        require(name.length <= 5) { "이름은 5글자를 초과할 수 없습니다." }
    }

    fun goOrNot(randomMoveStrategy: MoveStrategy) {
        if (randomMoveStrategy.canGO()) go()
    }

    private fun go() {
        position++
    }

    fun isSamePosition(car: Car): Boolean {
        return position == car.position
    }

    override fun compareTo(other: Car): Int {
        // 연산 사용해도 된다 ( position - other.position )
        return position.compareTo(other.position)
    }
}
