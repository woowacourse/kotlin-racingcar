package racingcar.model

object Messenger {
    fun getRoundResultMessage(roundResult: List<RoundResult>): String {
        return roundResult.joinToString("\n")
    }

    fun getWinnerMessage(winners: List<String>): String {
        return winners.joinToString(", ")
    }
}
