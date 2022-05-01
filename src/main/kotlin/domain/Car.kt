package domain

data class Car(val name: Name, var position: Int = 0) : Comparable<Car> {

    fun move(isMovable: Boolean) {
        if (isMovable) {
            position++
        }
    }

    override fun compareTo(other: Car): Int {
        return other.position - this.position
    }
}
