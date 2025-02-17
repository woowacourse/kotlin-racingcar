package racingcar.view

class OutputView {
    fun printCarName() {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
    }

    fun printReCarName() {
        println("자동차 이름은 5자를 초과하거나 공백일 수 없습니다. 다시 입력해주세요.")
    }

    fun printRound() {
        println("시도할 횟수는 몇 회인가요?")
    }

    fun printReRound() {
        println("올바른 숫자를 입력하세요.")
    }

    fun printResult() {
        println("\n실행결과")
    }
}
