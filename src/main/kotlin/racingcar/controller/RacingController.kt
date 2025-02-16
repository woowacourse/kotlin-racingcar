package racingcar.controller

import racingcar.domain.RacingGame

class RacingController {
    private lateinit var racingGame: RacingGame

    fun run() {
        racingGame = RacingGame()
    }
}
