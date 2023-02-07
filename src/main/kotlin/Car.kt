class Car(
    private val position: Int,
    private val name: String
) {
    init {
        require(name.length <= 5) {
            "[ERROR] 자동차 이름은 5자를 초과할 수 없다."
        }
    }
}
