package racingcar.utils

object CarNameParser {
    private const val DELIMITER = ","

    fun parse(carNames: String?): List<String> {
        if (carNames.isNullOrBlank()) throw IllegalArgumentException()
        return carNames.split(DELIMITER)
    }
}