data class Car(
    val name: String,
    private var _position: Int = INIT_POSITION,
    private val tryMoveNumberStrategy: TryMoveNumberStrategy = initTryMoveNumberStrategy,
) : Comparable<Car> {
    init {
        require(name.length <= CAR_NAME_LENGTH) { CAR_NAME_ERROR }
    }

    val position get() = _position

    fun move() {
        if (tryMoveNumberStrategy.getNumber() >= MOVE_MIN_NUMBER) _position++
    }

    override fun compareTo(other: Car): Int {
        return this.position - other.position
    }

    companion object {
        private const val CAR_NAME_ERROR = "[ERROR]: 자동차 이름은 5자 이내 입니다."
        private const val CAR_NAME_LENGTH = 5
        private const val INIT_POSITION = 0
        private const val MOVE_MIN_NUMBER = 4
        private val initTryMoveNumberStrategy: TryMoveNumberStrategy = TryMoveNumberGenerator()
    }
}
