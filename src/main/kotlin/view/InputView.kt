package view

import domain.Name
import java.util.Collections
import java.util.stream.Collectors

object InputView {

    private const val CAR_DELIMITER = ","
    private const val NUMBER_REGEX = "^[0-9]+$"

    val carNames: List<Name>
        get() {
            try {
                return splitCarNames(readLine().toString())
            } catch (e: IllegalArgumentException) {
                OutputView.printException(e.message)
                return carNames
            }
        }

    private fun splitCarNames(names: String): List<Name> {
        var carNames = names.split(CAR_DELIMITER)
        try {
            return carNames.stream()
                .map { Name(it) }
                .collect(Collectors.toList())
        } catch (e: IllegalArgumentException) {
            OutputView.printException(e.message)
            return splitCarNames(names)
        }
    }

    val numberOfGames: Int
        get() {
            val numberOfGames = try {
                val line = readLine().toString()
                toInt(line)
            } catch (e: IllegalArgumentException) {
                OutputView.printException(e.message)
                return InputView.numberOfGames
            }
            return numberOfGames
        }

    private fun validateDuplication(carNames: List<String>) {
        val isDuplicated = carNames.stream()
            .distinct()
            .count() == carNames.size.toLong()

        require(isDuplicated) { "자동차 이름은 중복이 되면 안됩니다." }
    }

    private fun toInt(line: String): Int {
        validateNumber(line)
        return line.toInt()
    }

    private fun validateNumber(number: String) {
        require(number.matches(Regex(NUMBER_REGEX)) && number.toInt() > 0) { "시도할 횟수는 양수만 입력 가능합니다." }
    }
}
