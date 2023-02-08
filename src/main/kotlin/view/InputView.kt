package view

import dto.CarNamesDTO
import dto.RaceTimeDTO

class InputView {
    fun readCarNames(): CarNamesDTO {
        println(GUIDE_CAR_NAME)
        val input = readUser()
        return CarNamesDTO(input)
    }

    fun readRaceTime(): RaceTimeDTO {
        println(GUIDE_RACE_TIME)
        val input = readUser()
        return RaceTimeDTO(input)
    }

    private fun readUser(): String {
        return readln()
    }

    companion object {
        const val GUIDE_CAR_NAME = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
        const val GUIDE_RACE_TIME = "시도할 횟수는 몇 회인가요?"
    }
}
