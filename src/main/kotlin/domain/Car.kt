package domain

import vo.Name
import vo.Position

data class Car(val name: Name, var position: Position = Position()) {

    fun move(isMovable: Boolean) {
        if (isMovable) {
            position.forward()
        }
    }
}
