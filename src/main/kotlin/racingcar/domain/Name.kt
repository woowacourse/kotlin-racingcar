package racingcar.domain

class Name(
    val value: String
) {
    init {
        if (value.length < 1 || value.length > 5) {
            throw IllegalArgumentException("자동차 이름은 1~5자여야 합니다.")
        }
    }
}
