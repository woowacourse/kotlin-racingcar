package util

import view.OutputView

class Validator {

    fun checkNames(names: String?) {
        checkNameNull(names)
        for (name in names!!.split(",")) {
            checkName(name.trim())
        }
    }

    fun checkName(name: String?) {
        checkNameNull(name)
        checkNameEmpty(name!!)
        checkNameSize(name)
        checkNameRight(name)
    }

    fun checkTryNumber(name: String?) {
        checkTryNumberNull(name)
        checkTryNumberIsRight(name ?: "")
    }

    private fun checkNameNull(name: String?) {
        require(name != null) { OutputView().outputErrorMessage(Constants.INPUT_NAME_NULL_ERROR_MESSAGE) }
    }

    private fun checkNameSize(name: String) {
        require(name.length < 5) { OutputView().outputErrorMessage(Constants.INPUT_NAME_SIZE_ERROR_MESSAGE) }
    }

    private fun checkNameEmpty(name: String) {
        require(name != "") { OutputView().outputErrorMessage(Constants.INPUT_NAME_NULL_ERROR_MESSAGE) }
    }

    private fun checkNameRight(name: String) {
        require(name.contains("^[a-zA-Z가-힣]*$".toRegex())) { OutputView().outputErrorMessage(Constants.INPUT_NAME_RIGHT_ERROR_MESSAGE) }
    }

    private fun checkTryNumberNull(number: String?) {
        require(number != null) { OutputView().outputErrorMessage(Constants.INPUT_TRY_NUMBER_NULL_ERROR_MESSAGE) }
    }

    private fun checkTryNumberIsRight(number: String) {
        require(
            number.isNotEmpty() && number.chars().allMatch { Character.isDigit(it) }) {
            OutputView().outputErrorMessage(
                Constants.INPUT_TRY_NUMBER_RIGHT_ERROR_MESSAGE
            )
        }
    }
}
