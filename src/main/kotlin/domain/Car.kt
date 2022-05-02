package domain

import vo.Name
import vo.Position

data class Car(val name: Name, var position: Position = Position()) : Comparable<Car> {

    fun move(isMovable: Boolean) {
        if (isMovable) {
            position.forward()
        }
    }

    override fun compareTo(other: Car): Int {
        return other.position.compareTo(other.position)
    }

    fun getPosition(): Int {
        return position.value()
    }
}
