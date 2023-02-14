package racing.view

import racing.model.Car

private const val PREFIX = "[Error]"

object InputView {
    fun inputCarNames(): List<Car> {
        val userInput = readlnOrNull()
        validateCarNames(userInput)
        return userInput!!.split(",").map { Car(it) }
    }

    private fun validateCarNames(userInput: String?) {
        require(userInput != null) { "$PREFIX 아무것도 입력하시지 않았습니다. 5글자이내의 자동차이름을 (,)로 구분하여 입력해주세요." }
        require(userInput.isNotBlank()) { "$PREFIX 공백으로만 이루어져 있습니다. 5글자이내의 자동차이름을 (,)로 구분하여 입력해주세요." }
    }

    fun inputCount(): Int {
        val userInput = readlnOrNull()
        validateCount(userInput)
        return userInput!!.toInt()
    }

    private fun validateCount(userInput: String?) {
        require(userInput != null) { "$PREFIX 아무것도 입력하시지 않았습니다. 레이스를 몇번 진행할 것인지 숫자로 입력해주세요." }
        require(userInput.toIntOrNull() != null) { "$PREFIX (입력한 값: $userInput) ${Int.MAX_VALUE} 이하의 정수만 입력이 가능합니다." }
    }
}
