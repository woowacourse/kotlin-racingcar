package view

object InputView {

    private const val CAR_NAMES_REQUEST_MSG = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).\n"
    private const val NUMBER_OF_TRY_REQUEST_MSG = "시도할 횟수는 몇 회인가요?\n"

    fun inputCarNames(): String? {
        println(CAR_NAMES_REQUEST_MSG)

        return readLine()
    }

    fun inputNumberOfTry(): String? {
        println(NUMBER_OF_TRY_REQUEST_MSG)

        return readLine()
    }
}
