package view

import dto.CarNamesDTO

class InputView {
    fun readCarNames(): CarNamesDTO {
        println(GUIDE_CAR_NAME)
        val input = readUser()
        return CarNamesDTO(input)
    }

    private fun readUser(): String {
        return readln()
    }

    companion object {
        const val GUIDE_CAR_NAME = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
    }
}
