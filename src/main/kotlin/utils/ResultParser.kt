package utils

object ResultParser {
    private const val DASH = "-"

    fun parseToDash(number: Int): String {
        return DASH.repeat(number)
    }
}