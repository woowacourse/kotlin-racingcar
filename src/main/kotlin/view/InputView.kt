package view

import model.Name
import model.TryCount
import validation.NameValidation
import validation.NameValidationResult
import validation.TryCountValidation
import validation.TryCountValidationResult

class InputView : InputViewInterface {
    private val nameValidation = NameValidation()
    private val tryCountValidation = TryCountValidation()

    override fun inputName(): Name {
        println(INPUT_CAR_NAMES_MESSAGE)
        val input = readlnOrNull()
        when (val result = nameValidation.checkNames(input)) {
            is NameValidationResult.Success -> return result.name
            is NameValidationResult.Failure -> println(result.errorMessage)
        }
        return inputName()
    }

    override fun inputTryCount(): TryCount {
        println(INPUT_TRY_COUNT_MESSAGE)
        val input = readlnOrNull()
        when (val result = tryCountValidation.checkTryCount(input)) {
            is TryCountValidationResult.Success -> return result.tryCount
            is TryCountValidationResult.Failure -> println(result.errorMessage)
        }
        return inputTryCount()
    }

    companion object {
        const val INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
        const val INPUT_TRY_COUNT_MESSAGE = "시도할 횟수는 몇 회인가요?"
    }
}
