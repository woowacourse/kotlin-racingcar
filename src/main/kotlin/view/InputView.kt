package view

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

object InputView {
    private const val CAR_DELIMITER = ","
    private const val NUMBER_REGEX = "^[0-9]+$"
    private val bufferedReader = BufferedReader(InputStreamReader(System.`in`))

    val carNames: List<String>
        get() {
            try {
                val line = readLine().toString()
                validateEmptyString(line)
                return splitCarNames(line)
            } catch (e: IllegalArgumentException) {
                OutputView.printException(e.message)
                return carNames
            } catch (e: IOException) {
                OutputView.printException(e.message)
                return carNames
            }
        }

    private fun splitCarNames(readLine: String): List<String> {
        val carNames = readLine.split(CAR_DELIMITER)
        try {
            validateDuplication(carNames)
        } catch (e: IllegalArgumentException) {
            OutputView.printException(e.message)
            return InputView.carNames
        }
        return carNames
    }

    val numberOfGames: Int
        get() {
            val numberOfGames = try {
                val line = bufferedReader.readLine()
                validateEmptyString(line)
                validateNumber(line)
                line.toInt()
            } catch (e: IllegalArgumentException) {
                OutputView.printException(e.message)
                return InputView.numberOfGames
            } catch (e: IOException) {
                OutputView.printException(e.message)
                return InputView.numberOfGames
            }
            return numberOfGames
        }

    private fun validateEmptyString(line: String) {
        require(line.isNotEmpty()) { "빈 문자열을 입력하면 안됩니다." }
    }

    private fun validateDuplication(carNames: List<String>) {
        val isDuplicated = carNames.stream()
            .distinct()
            .count() != carNames.size.toLong()
        require (!isDuplicated) {"자동차 이름은 중복이 되면 안됩니다."}
    }

    private fun validateNumber(number: String) {
        if (!number.matches(Regex(NUMBER_REGEX))) {
            throw IllegalArgumentException("시도할 횟수는 양수만 입력 가능합니다.")
        }
    }
}
