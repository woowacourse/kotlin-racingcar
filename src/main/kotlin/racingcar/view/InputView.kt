package racingcar.view

import racingcar.utils.InputExceptionUtils

class InputView {
    fun getCarNames(): List<String> {
        println(MESSAGE_CAR_NAME)
        val carName = readln()
        InputExceptionUtils.checkCarNames(carName)

        return carName.trim().split(",").map { it.trim() }
    }

    fun getRoundCount(): Int {
        println(MESSAGE_ROUND_COUNT)
        val round = readln()
        InputExceptionUtils.checkRoundCnt(round)

        return round.toInt()
    }

    companion object {
        const val MESSAGE_CAR_NAME = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
        const val MESSAGE_ROUND_COUNT = "시도할 횟수는 몇 회인가요?"
    }
}
