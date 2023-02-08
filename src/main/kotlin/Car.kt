class Car(
    private var position: Int,
    private val name: String
) {

    init {
        require(name.length <= 5) {
            "[ERROR] 자동차 이름은 5자를 초과할 수 없다."
        }
    }

    fun move() {
        val randomNumber = RacingNumberGenerator().generate()

        if (randomNumber >= 4) {
            position++
        }
    }

    fun getCar(): Pair<String, Int> {
        return Pair(name, position)
    }
}
