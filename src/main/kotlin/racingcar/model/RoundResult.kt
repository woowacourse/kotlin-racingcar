package racingcar.model

data class RoundResult(
    val carName: String,
    val carPosition: Int,
) {
    override fun toString(): String {
        return ROUND_RESULT_FORMAT.format(
            carName,
            HYPHEN.repeat(carPosition),
        )
    }

    companion object {
        const val ROUND_RESULT_FORMAT = "%s : %s"
        const val HYPHEN = "-"
    }
}
