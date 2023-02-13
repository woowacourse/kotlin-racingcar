package racingcar.utils

object Random {
    fun pickInRange(start: Int, end: Int): Int = (start..end).random()
}
