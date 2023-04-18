package racingcar.domain

class Car(private val name: String, private val position: Int) {

    fun move(number: Int): Car {
        if (number > 4) {
            return Car(name, position + 1)
        }
        return this
    }
}
