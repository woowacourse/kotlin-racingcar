package model

class Car(private val name: String, private var position: Int) : Comparable<Car> {
    fun moveForward(isPossibleMove: Boolean) {
        if (isPossibleMove) this.position += 1
    }

    fun isSamePosition(other: Car): Boolean {
        return other.position == this.position
    }

    fun isPossibleMove(number: Int): Boolean = number >= 4

    fun getPresentStatus(): String {
        var status = "${this.name} : "
        for (i in 1..this.position) status += "-"
        return status
    }

    fun getWinnerName(): String {
        return this.name
    }

    override fun compareTo(other: Car): Int {
        return this.position - other.position
    }
}
