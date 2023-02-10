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
        for (i in 1..this.position) status += "-"
        return status
    }

    override fun compareTo(other: Car): Int {
        return this.position - other.position
    }

    companion object {
        const val MOVE_POSITION = 1
        const val MOVE_CONDITION = 4
    }
}
