package view

class InputView {

    fun readCars(): String {
        println(HEADER_READ_CARS)
        return readlnOrNull() ?: throw IllegalArgumentException(INPUT_IS_NULL)
    }

    companion object {
        const val HEADER_READ_CARS = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
        const val INPUT_IS_NULL = "입력이 있어야 합니다"
    }
}