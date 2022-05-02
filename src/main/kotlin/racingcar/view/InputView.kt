package racingcar.view

object InputView {

    fun inputCarNames(): List<String> {
        return prompt("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).").split(",")
    }

    fun inputTryNumber(): String {
        return prompt("시도할 횟수는 몇 회인가요?")
    }

    private fun prompt(message: String): String {
        println(message)
        return readln()
    }
}
