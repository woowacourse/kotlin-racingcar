package view

class InputView {
    fun readCars(): String {
        println(HEADER_READ_CARS)
        return readlnOrNull() ?: throw IllegalArgumentException(INPUT_IS_NULL)
    }

    fun readTryCount(): String {
        println(HEADER_READ_TRY_COUNT)
        return readlnOrNull() ?: throw IllegalArgumentException(INPUT_IS_NULL)
    }

    companion object {
        private const val HEADER_READ_CARS = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
        private const val INPUT_IS_NULL = "입력이 있어야 합니다"
        private const val HEADER_READ_TRY_COUNT = "시도할 횟수는 몇 회인가요?"
    }
}
