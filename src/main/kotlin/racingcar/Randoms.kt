package racingcar

class Randoms(private val amount: Int) {
    fun generate(): List<Int> =
        (1..amount).map { (0..9).random() }
}
