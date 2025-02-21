package racingcar

import racingcar.global.Configure.RANDOM_SEED
import kotlin.random.Random

fun main() {
    val random = Random(RANDOM_SEED)
    val raceService = RaceService(random)
    val view = View()
    Controller(raceService, view, random).run()
}
