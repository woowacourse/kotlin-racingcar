package racingcar.car

import java.lang.IllegalArgumentException

class Car(name: String) {
    private val name : String? = name
    private var position : Int = 0

    init {
        validateName(name)
    }

    fun tryToMove(num: Int){
        if(num >= 4){
            position++
        }
    }

    fun isIn(position : Int) : Boolean{
        return this.position == position;
    }

    fun position() : Int{
        return position
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

    override fun toString(): String {
        return "Car(name=$name, position=$position)"
    }
}