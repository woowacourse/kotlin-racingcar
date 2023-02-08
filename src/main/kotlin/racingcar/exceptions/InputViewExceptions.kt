package racingcar.exceptions

class InputViewExceptions {
    fun validateNames(names: List<String>) {
        require(names.isNotEmpty()) { "경주를 시작하려면 차 이름을 입력해주세요" }
        require(names.all { it.isNotEmpty() }) { "차 이름은 1글자 이상이어야 합니다." }
        require(names.all { it.length <= 5 }) { "차 이름은 5글자 이하여야 합니다." }
    }

    fun validateAttemptCount(input: String) {
        require(input.toIntOrNull() != null) { "시도 횟수는 숫자만 입력가능합니다." }
    }
}
