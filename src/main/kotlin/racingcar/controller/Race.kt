package racingcar.controller

import racingcar.model.RaceManager

class Race {
    private val raceManager = RaceManager()
    private var roundNumber: Int = INITIAL_ROUND_NUMBER

    fun start() {
        raceManager.apply {
            showCarNamesGuide()
            getCars()
            showRoundNumberGuide()
            roundNumber = getRoundNumber()
            showResult(roundNumber)
            showWinners()
        }
    }

    companion object {
        const val ERROR_REQUEST_INPUT = "[Error] 값을 입력해 주세요"

        const val INITIAL_ROUND_NUMBER = 0
    }
}
