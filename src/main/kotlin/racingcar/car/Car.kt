package racingcar.car

import java.lang.IllegalArgumentException

class Car(name: String) {
    val name : String? = name
    var position : Int = 0

    init {
        validateName(name)
    }

    // name 포장하기
    private fun validateName(name: String){
        if(name.isBlank()){
            throw IllegalArgumentException("이름은 빈 문자열일 수 없습니다.")
        }

        if(name.length > 5){
            throw IllegalArgumentException("이름은 5글자 초과일 수 없습니다.")
        }
    }
}