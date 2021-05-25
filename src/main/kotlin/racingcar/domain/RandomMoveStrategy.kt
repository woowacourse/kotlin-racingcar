package racingcar.domain

val randomMoveStrategy: () -> Boolean = fun(): Boolean {
    val randomNumber = Math.random() * 10 + 1
    if (randomNumber >= 4) {
        return true
    }
    return false
}
