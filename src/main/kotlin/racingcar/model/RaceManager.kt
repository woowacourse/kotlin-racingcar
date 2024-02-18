package racingcar.model

import racingcar.view.InputView
import racingcar.view.OutputView

class RaceManager {
    private val outputView = OutputView()
    private val inputView = InputView()

    fun showRoundNumberGuide() = outputView.printRoundNumberGuide()

    private fun getRoundNumberInput() = inputView.readRoundNumber()

    fun getRoundNumber(): Int {
        var roundNumber : String

        while (true) {
            try {
                roundNumber = getRoundNumberInput()
                break
            } catch (e: IllegalArgumentException) {
                outputView.printErrorMessage(e.message)
            }
        }
        return roundNumber.toInt()
    }
}