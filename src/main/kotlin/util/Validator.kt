package util

class Validator {

    fun checkNames(names: String?) {
        checkNameNull(names)
        checkNameEmpty(names!!)
    }

    fun checkName(name: String?) {
        checkNameNull(name)
        checkNameEmpty(name!!)
        checkNameSize(name)
        checkNameRight(name)
    }

    fun checkTryNumber(name: String?) {
        checkTryNumberNull(name)
        checkTryNumberIsRight(name)
        checkTryNumberLimit(name)
    }

    private fun checkNameNull(name: String?) {
        require(name != null) { INPUT_NAME_NULL_ERROR_MESSAGE }
    }

    private fun checkNameSize(name: String) {
        require(name.length < 5) { INPUT_NAME_SIZE_ERROR_MESSAGE }
    }

    private fun checkNameEmpty(name: String) {
        require(name != "") { INPUT_NAME_NULL_ERROR_MESSAGE }
    }

    private fun checkNameRight(name: String) {
        require(name.contains("^[a-zA-Z가-힣]*$".toRegex())) { INPUT_NAME_RIGHT_ERROR_MESSAGE }
    }

    private fun checkTryNumberNull(number: String?) {
        require(number != null) { INPUT_TRY_NUMBER_NULL_ERROR_MESSAGE }
    }

    private fun checkTryNumberIsRight(number: String?) {
        require(number!!.toIntOrNull() != null) { INPUT_TRY_NUMBER_RIGHT_ERROR_MESSAGE }
    }

    private fun checkTryNumberLimit(number: String?) {
        require(number!!.toInt() in 1..100) { INPUT_TRY_NUMBER_LIMIT_ERROR_MESSAGE }
    }

    companion object {
        const val INPUT_NAME_SIZE_ERROR_MESSAGE = "자동차 이름의 길이가 5를 초괴합니다."
        const val INPUT_NAME_NULL_ERROR_MESSAGE = "자동차 이름이 입력되지 않았습니다."
        const val INPUT_TRY_NUMBER_NULL_ERROR_MESSAGE = "시도할 횟수가 입력되지 않았습니다."
        const val INPUT_TRY_NUMBER_RIGHT_ERROR_MESSAGE = "시도할 횟수가 올바르게 입력되지 않았습니다."
        const val INPUT_NAME_RIGHT_ERROR_MESSAGE = "자동차 이름은 한글과 영어만 가능합니다."
        const val INPUT_TRY_NUMBER_LIMIT_ERROR_MESSAGE = "시도할 횟수가 1번 이상 100번 이하여야 합니다."
    }
}
