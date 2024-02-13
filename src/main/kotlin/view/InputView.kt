package view

import util.Validation

class InputView {
    fun readCarsName(): List<String> {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        val carsName = readln()
        Validation.carsName(carsName)
        return carsName.split(",")
    }

    fun readAttemptCount(): Int {
        println("시도할 횟수는 몇 회인가요?")
        val attemptCount = readln()
        Validation.attemptCount(attemptCount)
        return attemptCount.toInt()
    }
}