data class Car(val name: String) {
    init {
        require(name.length <= CAR_NAME_LENGTH) { CAR_NAME_ERROR }
    }

    private var _position = INIT_POSITION
    val position get() = _position

    fun move(tryMoveNumberStrategy: TryMoveNumberStrategy) {
        if (tryMoveNumberStrategy.getNumber() >= MOVE_MIN_NUMBER) _position++
    }

    companion object {
        private const val CAR_NAME_ERROR = "[ERROR]: 자동차 이름은 5자 이내 입니다."
        private const val CAR_NAME_LENGTH = 5
        private const val INIT_POSITION = 0
        private const val MOVE_MIN_NUMBER = 4
    }
}
