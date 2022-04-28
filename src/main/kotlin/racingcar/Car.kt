package racingcar

class Car(val name: String, var position : Int = 0) {
    init {
        validateNameSpace(name)
    }

    private fun validateNameSpace(name : String) {
        if (name != name.replace(" ", "")) {
            throw IllegalArgumentException("[ERROR] 이름에 공백이 존재합니다.")
        }
    }
}
