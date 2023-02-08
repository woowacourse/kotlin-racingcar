package view

import view.validator.InputValidator

object InputView {
    fun readCarNames(): List<String> {
        while (true) {
            val carNames = readln()
            kotlin.runCatching { InputValidator.validateCarNames(carNames) }
                .onSuccess { return carNames.split(",").map { it.trim() } }
                .onFailure { println(it.message) }
        }
    }

    fun readAdvanceCount(): Int {
        while (true) {
            val count = readln()
            kotlin.runCatching { InputValidator.validateAdvanceCount(count)}
                .onSuccess { return count.toInt() }
                .onFailure { println(it.message) }
        }
    }
}
