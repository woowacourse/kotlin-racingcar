package racingcar

class Car(val name: String, var position : Int = 0) {
    init {
        validateNoName(name)
        validateNameSpace(name)
    }

    private fun validateNameSpace(name : String) {
        if (name != name.replace(" ", "")) {
            throw IllegalArgumentException("[ERROR] 이름에 공백이 존재합니다.")
        }
    }

    private fun validateNoName(name : String) {
        if (name.isBlank()) {
            throw IllegalArgumentException("[ERROR] 이름을 입력하지 않았습니다.")
        }
    }
}
