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
        position++
    }

    fun getName(): String {
        return name
    }
}
