package view

import constant.InOutConstant

class InOutView {
    fun getCarNames(): String {
        println(InOutConstant.INPUT_CAR_NAME)
        return readln()
    }

    fun getTryCount(): String {
        println(InOutConstant.INPUT_TRY_COUNT)
        return readln()
    }
}