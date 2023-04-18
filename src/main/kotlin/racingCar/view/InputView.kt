package racingCar.view

class InputView {

    fun readCarNames(): List<String> {
        println("자동차 이름을 입력해주세요")
        return splitCarNames(readLine()) ?: throw NullPointerException("이름을 입력하세요")
    }

    private fun splitCarNames(input: String?): List<String>? {
        return input?.split(",")
    }

    fun readTryCount(): Int {
        println("시도 횟수를 입력해주세요")
        return readLine()?.toInt() ?: throw NullPointerException("숫자를 입력하세요")
    }
}
