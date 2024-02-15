package racingcar.view

class OutputView {
    fun printCarNamesGuide() = println(REQUEST_CAR_NAMES_GUIDE)

    companion object {
        const val REQUEST_CAR_NAMES_GUIDE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
    }
}
