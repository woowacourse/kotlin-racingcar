package racingcar.controller

import racingcar.view.InputView
import racingcar.view.OutputView

class Race {
    private val outputView = OutputView()
    private val inputView = InputView()

    fun getNames(): List<String> {
        outputView.printCarNamesGuide()
        lateinit var names: List<String>

        while (true) {
            try {
                names = inputView.readCarNames().split(",")
                validateNames(names)
                names.forEach { name ->
                    Car(name)
                }
                break
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }

        return names
    }

    fun validateNames(names: List<String>) {
        require(names.isNotEmpty()) { ERROR_MESSAGE }
        require(names.size > 1) { ERROR_MESSAGE }
        require(names.size < 21) { ERROR_MESSAGE }
        require(names.distinct().size == names.size) { ERROR_MESSAGE }
    }

    fun getRoundNumber(): Int {
        outputView.printRoundNumberGuide()
        var roundNumber: Int

        while (true) {
            try {
                val roundNumberInput = inputView.readRoundNumber()

                break
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }

        return roundNumber
    }

    companion object {
        const val ERROR_MESSAGE = "잘못된 입력입니다."
    }
}
