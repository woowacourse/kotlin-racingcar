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
        nameValidation.checkNames(input).onSuccess { name ->
            return name
        }.onFailure { error ->
            println(error.message)
            return inputName()
        }.also { result ->
            return result.getOrThrow()
        }
    }

    override fun inputTryCount(): TryCount {
        println(INPUT_TRY_COUNT_MESSAGE)
        val input = readlnOrNull()
        tryCountValidation.checkTryCount(input).onSuccess { tryCount ->
            return tryCount
        }.onFailure { error ->
            println(error.message)
            return inputTryCount()
        }.also { result ->
            return result.getOrThrow()
        }
    }

    companion object {
        const val INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
        const val INPUT_TRY_COUNT_MESSAGE = "시도할 횟수는 몇 회인가요?"
    }
}
