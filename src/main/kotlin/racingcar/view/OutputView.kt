package racingcar.view

object OutputView {
    fun print(string: String) = println(string)

    fun printRacingResult() = println("실행 결과")

    fun printWinner(winner: String) {
        println("최종 우승자 : $winner")
    }
}
