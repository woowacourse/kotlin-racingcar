package racingCar.view

class OutputView {
    fun printRaceCarNamesGuide() {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
    }

    fun printRaceCountGuide() {
        println("시도할 횟수는 몇 회인가요?")
    }

    fun printRaceResultTitle() {
        printLineBreak()
        println("실행 결과")
    }

    fun printRaceProgress(
        carName: String,
        carPosition: Int,
    ) {
        println("$carName : ${RACE_CAR_POSITION_INDICATOR.repeat(carPosition)}")
    }

    fun printWinners(winnerNames: List<String>) {
        println("최종 우승자: ${winnerNames.joinToString(RACE_WINNER_NAMES_DIVIDER)}")
    }

    fun printErrorMessage(message: String) {
        println(message)
    }

    fun printLineBreak() {
        println()
    }

    companion object {
        private const val RACE_CAR_POSITION_INDICATOR = "-"
        private const val RACE_WINNER_NAMES_DIVIDER = ", "
    }
}
