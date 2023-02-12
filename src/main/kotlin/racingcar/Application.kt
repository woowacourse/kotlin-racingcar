package racingcar

import racingcar.domain.RacingGame
import racingcar.domain.Referee
import racingcar.domain.numbergenerator.RandomNumberGenerator

fun main() {
    val generator = RandomNumberGenerator()
    val referee = Referee()
    RacingGame(generator, referee).runGame()
}
