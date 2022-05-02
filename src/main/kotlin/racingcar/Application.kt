package racingcar

import racingcar.controller.Controller
import racingcar.domain.RandomMoveStrategy

fun main() {
    Controller().run(RandomMoveStrategy())
}
