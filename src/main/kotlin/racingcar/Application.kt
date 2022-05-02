package racingcar

import racingcar.controller.Controller
import racingcar.domain.RandomMoveStrategy

fun main() {
    val controller = Controller()
    controller.run(RandomMoveStrategy())
}
