package racingcar.view

class OutputView {
    fun printCarNamesGuide() = println(REQUEST_CAR_NAMES_GUIDE)

    fun printRoundNumberGuide() = println(REQUEST_ROUND_NUMBER_GUIDE)

    companion object {
        const val REQUEST_CAR_NAMES_GUIDE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
        const val REQUEST_ROUND_NUMBER_GUIDE = "시도할 횟수는 몇 회인가요?"
    }
}
