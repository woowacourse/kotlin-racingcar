package model

class Car(val name: String, private var position: Int) : Comparable<Car> {
    fun moveForward(isPossibleMove: Boolean) {
        if (isPossibleMove) this.position += MOVE_POSITION
    }

    fun isSamePosition(other: Car): Boolean {
        return other.position == this.position
    }

    fun isPossibleMove(number: Int): Boolean = number >= MOVE_CONDITION

    fun getPresentStatus(): String {
        var status = "${this.name} : "
        repeat(position) {
            status += "-"
        }
        return status
    }

    override fun compareTo(other: Car): Int {
        return this.position - other.position
    }

    companion object {
        private const val MOVE_POSITION = 1
        private const val MOVE_CONDITION = 4
    }
}
