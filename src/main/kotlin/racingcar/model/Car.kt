package racingcar.model

const private val needCarLen="자동차 이름은 1자 이상 5자 이하이어야 합니다. 입력된 이름:"
class Car(val name: String, var position: Int = 0) {
    init {
        require(name.length in 1..5) {
            "$needCarLen $name"
        }
    }
}