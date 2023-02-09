package racingcar.view

class InputView {
    fun carNames(): List<String> {
        val input = readln()
        val names = input.split(",")
        require(input.isNotEmpty()) { "경주를 시작하려면 차 이름을 입력해주세요" }
        return names
    }

    fun attemptCount(): Int {
        val input = readln()
        require(input.toIntOrNull() != null) { "시도 횟수는 숫자만 입력가능합니다." }
        return input.toInt()
    }
}
