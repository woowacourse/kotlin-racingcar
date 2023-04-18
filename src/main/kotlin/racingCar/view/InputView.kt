package racingCar.view

class InputView {

    fun readCarNames(): List<String>? {
        println("자동차 이름을 입력해주세요")
        return splitCarNames(readLine())
    }

    private fun splitCarNames(input : String?): List<String>? {
        return input?.split(",")
    }

    fun readTryCount(): String? {
        println("시도회수를 입력해주세요")
        return readLine()
    }

}
