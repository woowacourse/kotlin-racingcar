package racingcar.domain

class Car(private val name: String, private val position: Int) {
    init {
        validate(name)
    }

    private fun validate(name: String) {
        if (name.length >= 5) {
            throw IllegalArgumentException("이름은 5자 이하만 가능합니다")
        }
    }

    fun move(number: Int): Car {
        if (number > 4) {
            return Car(name, position + 1)
        }
        return this
    }
}
