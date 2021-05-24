package racingcar.domain

val randomMoveStrategy: () -> Boolean = {
    val randomNumber = Math.random() * 10 + 1
    if (randomNumber >= 4) {
        true
    }
    false
}
