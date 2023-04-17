package racingcar.domain

class Car(name: String, position: Int = 0) {

    private val name: String
    private var position: Int

    init {
        this.name = name.trim().also {
            if (name.isBlank() || name.length > 5) throw IllegalArgumentException("이름의 길이는 0 이상 5 이하입니다")
        }
        this.position = position.also {
            if (position < 0) throw IllegalArgumentException("위치값은 0 이상이어야 합니다")
        }
    }

    fun move(power: Int) {
        if (power >= 4) {
            this.position++
        }
    }

    fun getName(): String {
        return this.name
    }

    fun getPosition(): Int {
        return this.position
    }
}
