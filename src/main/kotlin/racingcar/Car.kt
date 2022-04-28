package racingcar

const val MAX_LENGTH = 5;

data class Car(val name: String, var position : Int = 0) {


    init {
        validateCarName(name)
    }

    private fun validateCarName(name : String) {
        if (name.isBlank()) {
            throw IllegalArgumentException("[ERROR] 이름을 입력하지 않았습니다.")
        }

        if (name != name.replace(" ", "")) {
            throw IllegalArgumentException("[ERROR] 이름에 공백이 존재합니다.")
        }

        if (name.length > MAX_LENGTH) {
            throw IllegalArgumentException("[ERROR] 이름은 5자 이하로 입력하세요.")
        }
    }

}
