package racingcar.utils

class Validator {
    fun checkCarNames(names: List<String>): List<String> {
        checkDuplicatedCarNames(names)
        return names
    }

    private fun checkDuplicatedCarNames(names: List<String>) {
        if (names.toSet().size != names.size) {
            throw IllegalArgumentException(DUPLICATED_CAR_NAME_ERROR_MESSAGE)
        }
    }

    companion object {

        const val DUPLICATED_CAR_NAME_ERROR_MESSAGE =
            "중복된 자동차 이름이 존재합니다."
    }
}
