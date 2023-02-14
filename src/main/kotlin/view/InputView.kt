package view

class InputView {
    fun readCarNames(): List<String> {
        println(GUIDE_CAR_NAME)
        return readlnOrNull()?.split(',') ?: listOf()
    }

    fun readRaceTime(): Int {
        println(GUIDE_RACE_TIME)
        return requireNotNull(readln().toIntOrNull())
    }

    companion object {
        const val GUIDE_CAR_NAME = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
        const val GUIDE_RACE_TIME = "시도할 횟수는 몇 회인가요?"
    }
}
