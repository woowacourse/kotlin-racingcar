package racingcar.domain

class Car(val name: String) : Comparable<Car> {

    var position: Int = 0
        private set

    init {
        if (name.isBlank()) {
            throw IllegalArgumentException("공백을 입력하면 안 됩니다.")
        }
        if (name.length > 5) {
            throw IllegalArgumentException("이름은 5글자를 초과할 수 없습니다.")
        }
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
        return position.compareTo(other.position)
    }
}
