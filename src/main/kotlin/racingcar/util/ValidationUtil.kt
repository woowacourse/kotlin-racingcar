package racingcar.util

class ValidationUtil {
    fun validateCarNames(carNames: String?) {
        require(carNames != null) { "ERROR : 자동차의 이름을 입력해주세요." }
        val splitCarNames: List<String> = carNames.split(",")
        require(splitCarNames.all { it.matches(Regex("^[가-힣A-Za-z0-9]{1,5}$")) }) { "ERROR : 자동차의 이름은 한글, 영어, 숫자로 이루어진 1~5글자여야 합니다." }
        require(splitCarNames.size == splitCarNames.toSet().size) { "ERROR : 자동차의 이름은 중복될 수 없습니다." }
    }

    fun validateRoundCounts(roundCounts: String?) {
        require(roundCounts != null) { "ERROR : 시도할 횟수를 입력해주세요." }
        require(roundCounts.toIntOrNull()?.let { it > 0 } == true) { "ERROR : 시도할 횟수는 자연수여야합니다." }
    }

}