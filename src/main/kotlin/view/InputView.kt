package view

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.util.Arrays
import java.util.function.Consumer

object InputView {

    private const val MIN_NAME_LENGTH = 1
    private const val MAX_NAME_LENGTH = 5
    private const val CAR_DELIMITER = ","
    private const val NUMBER_REGEX = "^[0-9]+$"
    private val bufferedReader = BufferedReader(InputStreamReader(System.`in`))

    val carNames: List<String>
        get() {
            var line = ""
            try {
                line = bufferedReader.readLine()
                validateEmptyString(line)
            } catch (e: IllegalArgumentException) {
                OutputView.printException(e.message)
                return carNames
            } catch (e: IOException) {
                OutputView.printException(e.message)
                return carNames
            }
            return splitCarNames(line)
        }

    private fun splitCarNames(readLine: String): List<String> {
        val carNames = Arrays.asList(*readLine.split(CAR_DELIMITER.toRegex()).dropLastWhile { it.isEmpty() }
            .toTypedArray())
        try {
            validateNameSize(carNames)
            validateDuplication(carNames)
        } catch (e: IllegalArgumentException) {
            OutputView.printException(e.message)
            return InputView.carNames
        }
        return carNames
    }

    val numberOfGames: Int
        get() {
            var numberOfGames = 0
            numberOfGames = try {
                val line = bufferedReader.readLine()
                validateEmptyString(line)
                toInt(line)
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
        if (line.isEmpty()) {
            throw IllegalArgumentException("빈 문자열을 입력하면 안됩니다.")
        }
    }

    private fun validateNameSize(carNames: List<String>) {
        carNames.forEach(Consumer { carName: String ->
            if (carName.length < MIN_NAME_LENGTH || carName.length > MAX_NAME_LENGTH) {
                throw IllegalArgumentException("자동차 이름의 길이는 한 글자 이상, 다섯 글자 이하여야합니다.")
            }
        })
    }

    private fun validateDuplication(carNames: List<String>) {
        val isDuplicated = carNames.stream()
            .distinct()
            .count() != carNames.size.toLong()
        if (isDuplicated) {
            throw IllegalArgumentException("자동차 이름은 중복이 되면 안됩니다.")
        }
    }

    private fun toInt(line: String): Int {
        validateNumber(line)
        return line.toInt()
    }

    private fun validateNumber(number: String) {
        if (!number.matches(Regex(NUMBER_REGEX)) || number.toInt() == 0) {
            throw IllegalArgumentException("시도할 횟수는 양수만 입력 가능합니다.")
        }
    }
}
