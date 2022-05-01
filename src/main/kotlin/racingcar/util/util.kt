package racingcar.util

fun parseInt(string: String): Int {
    try {
        return string.toInt()
    } catch (e : NumberFormatException) {
        throw IllegalArgumentException("$string 을 숫자로 변환할 수 없습니다.")
    }
}