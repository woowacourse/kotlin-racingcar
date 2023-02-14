package racingcar.view

import racingcar.model.CarManager

object InputView {
    fun carNames(): List<String> {
        val input = readln()
        val names = input.split(",")
        require(input.isNotEmpty()) { "경주를 시작하려면 차 이름을 입력해주세요" }
        require(names.size >= CarManager.MIN_CAR_COUNT) { "경주에는 자동차 2대 이상이 필요합니다." }
        return names
    }

    fun attemptCount(): Int {
        val input = readln()
        require(input.toIntOrNull() != null) { "시도 횟수는 숫자만 입력가능합니다." }
        return input.toInt()
    }
}
