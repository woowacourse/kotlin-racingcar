package racingcar.view

class InputView {
    fun insertCarNames(): List<String> {
        println(INPUT_CARNAMES_MESSAGE)
        return readln().split(COMMA)
    }

    fun insertTryCount(): Int? {
        println(INPUT_TRYCOUNT_MESSAGE)
        return readln().toIntOrNull()
    }

    companion object {
        private const val INPUT_CARNAMES_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
        private const val INPUT_TRYCOUNT_MESSAGE = "시도할 횟수는 몇 회인가요?"
        private const val COMMA = ","
    }
}
