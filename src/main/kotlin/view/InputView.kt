package view

import util.Validation

class InputView {
    fun readCarsName(): List<String> {
        println(CAR_NAME_READ_COMMENT)
        val carsName = readln()
        Validation.carsName(carsName)
        return carsName.split(CAR_NAME_SPLITTER)
    }

    fun readAttemptCount(): Int {
        println(ATTEMPT_COUNT_READ_COMMENT)
        val attemptCount = readln()
        Validation.attemptCount(attemptCount)
        return attemptCount.toInt()
    }

    companion object {
        private const val CAR_NAME_READ_COMMENT = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
        private const val CAR_NAME_SPLITTER = ","
        private const val ATTEMPT_COUNT_READ_COMMENT = "시도할 횟수는 몇 회인가요?"
    }
}
