package model

class Car(
    val name: String,
    var step: Int = 0,
) {
    init {
        require(name.trim().length in 1..4){ CAR_NAME_LENGTH }
    }

    private companion object{
        const val CAR_NAME_LENGTH = "자동차 이름의 길이는 최소 1글자 최대 4글자여야 합니다."
    }
}