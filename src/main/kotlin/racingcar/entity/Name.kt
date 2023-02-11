package racingcar.entity

data class Name(val value: String) {
    init {
        require(value.isNotEmpty()) { "차 이름은 1글자 이상이어야 합니다." }
        require(value.length <= MIN_CAR_NAME_LENGTH) { "차 이름은 5글자 이하여야 합니다." }
    }

    companion object {
        const val MIN_CAR_NAME_LENGTH = 5
    }
}
