package view

import model.Name
import model.TryCount
import validation.NameValidation
import validation.TryCountValidation

class InputView : InputViewInterface {
    private val nameValidation = NameValidation()
    private val tryCountValidation = TryCountValidation()

    override fun inputName(): Name {
        println(INPUT_CAR_NAMES_MESSAGE)
        val input = readlnOrNull()
        runCatching { nameValidation.checkNames(input) }.onSuccess { value ->
            value.getOrNull()
        }.onFailure { value ->
            println(value.message)
        }
        return inputName()
    }

    override fun inputTryCount(): TryCount {
        println(INPUT_TRY_COUNT_MESSAGE)
        val input = readlnOrNull()
        runCatching { tryCountValidation.checkTryCount(input) }.onSuccess { result ->
            result.getOrNull()
        }.onFailure { error ->
            println(error.message)
        }
        return inputTryCount()
    }

    companion object {
        const val INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
        const val INPUT_TRY_COUNT_MESSAGE = "시도할 횟수는 몇 회인가요?"
    }
}
