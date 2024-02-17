package racingcar.model

class Car(var name: String, var position: Int = 0) {
    fun move(distance: Int) {
        position += distance
    }
}



