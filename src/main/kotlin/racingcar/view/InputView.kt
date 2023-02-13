package racingcar.view

import racingcar.racingcar.view.InputInterface

class InputView : InputInterface {
    override fun inputCarNames(): List<String> {
        println(CAR_NAMES)
        return readlnOrNull()?.split(',') ?: List(0) { "" }
    }

    override fun inputRacingCount(): Int {
        println(TRY_COUNT)
        return readlnOrNull()?.toIntOrNull() ?: 0
    }

    companion object {
        private const val CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)"
        private const val TRY_COUNT = "시도할 횟수는 몇 회인가요?"
    }
}
