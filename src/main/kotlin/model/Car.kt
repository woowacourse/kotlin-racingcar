package model

class Car(val name: String, position: Int) : Comparable<Car> {

    var position = 0
        private set

    fun moveForward(isPossibleMove: Boolean) {
        if (isPossibleMove) this.position++
    }

    fun isSamePosition(other: Car): Boolean {
        return other.position == this.position
    }

    fun isPossibleMove(number: Int): Boolean = number >= 4

    fun getPresentStatus(): String {
        var status = "${this.name} : "
        repeat(this.position) { status += "-" }
        return status
    }

    override fun compareTo(other: Car): Int {
        return this.position - other.position
    }
}
