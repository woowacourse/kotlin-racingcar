package racingcar.view

class InputView {

    fun sendCarName(): List<String> {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        return readln().split(",")
    }

    fun sendRound(): Int {
        println("시도할 횟수는 몇 회인가요?")
        return runCatching {
            readln().toInt()
        }.onFailure {
            when (it) {
                is NumberFormatException -> println("숫자를 입력해주세요")
                else -> throw it
            }
        }.getOrElse {
            sendRound()
        }
    }
}
