package view

import dto.CarNames
import dto.RaceTime
import utils.CarNamesValidator
import utils.RaceTimeValidator

class InputView {
    fun readCarNames(): CarNames {
        return CarNames(getValidCarNames())
    }

    fun readRaceTime(): RaceTime {
        return RaceTime(getValidRaceTime())
    }

    private fun readUser(): String {
        return readln()
    }

    private fun getValidCarNames(): List<String> {
        var input = ""
        var isValidCarNames = false
        while (!isValidCarNames) {
            println(GUIDE_CAR_NAME)
            input = readUser()
            isValidCarNames = validateCarNames(input)
        }
        return input.split(",")
    }

    private fun validateCarNames(input: String): Boolean {
        return try {
            CarNamesValidator().validate(input)
            true
        } catch (e: IllegalArgumentException) {
            printInputError(e.message ?: "")
            false
        }
    }

    private fun getValidRaceTime(): Int {
        var input = ""
        var isValidRaceTime = false
        while (!isValidRaceTime) {
            println(GUIDE_RACE_TIME)
            input = readUser()
            isValidRaceTime = validateRaceTime(input)
        }
        return input.toInt()
    }

    private fun validateRaceTime(input: String): Boolean {
        return try {
            RaceTimeValidator().validate(input)
            true
        } catch (e: IllegalArgumentException) {
            printInputError(e.message ?: "")
            false
        }
    }

    private fun printInputError(errorMessage: String) {
        println("$ERROR_HEADER $errorMessage")
    }

    companion object {
        const val ERROR_HEADER = "[ERROR]"
        const val GUIDE_CAR_NAME = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
        const val GUIDE_RACE_TIME = "시도할 횟수는 몇 회인가요?"
    }
}
