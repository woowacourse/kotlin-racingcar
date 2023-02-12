package view

import dto.CarNamesDTO
import dto.RaceTimeDTO
import utils.CarNamesValidator
import utils.RaceTimeValidator

class InputView {
    fun readCarNames(): CarNamesDTO {
        println(GUIDE_CAR_NAME)
        val input = readUser()
        val validator = CarNamesValidator()
        return CarNamesDTO(validator.validate(input))
    }

    fun readRaceTime(): RaceTimeDTO {
        println(GUIDE_RACE_TIME)
        val input = readUser()
        val validator = RaceTimeValidator()
        return RaceTimeDTO(validator.validate(input))
    }

    private fun readUser(): String {
        return readln()
    }

    companion object {
        const val GUIDE_CAR_NAME = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
        const val GUIDE_RACE_TIME = "시도할 횟수는 몇 회인가요?"
    }
}
