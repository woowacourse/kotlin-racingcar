package racingcar.model

data class Car(val name: String, var position: Int = 0) {
    init {
        require(name.isNotEmpty()) { ERROR_MESSAGE }
        require(name.length in 1..5) { ERROR_MESSAGE }
        require(!name.contains(" ")) { ERROR_MESSAGE }
    }

    companion object {
        const val ERROR_MESSAGE = "잘못된 입력입니다."
    }
}
