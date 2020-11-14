package racingcar.utils

object CarNameParser {
    private const val DELIMITER = ","

    fun parse(carNames: String?): List<String> {
        require(!carNames.isNullOrBlank())
        return carNames.split(DELIMITER)
    }
}