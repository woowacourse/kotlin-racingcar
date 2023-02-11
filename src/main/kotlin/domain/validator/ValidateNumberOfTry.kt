package domain.validator

class ValidateNumberOfTry {

    operator fun invoke(numberOfTry: String): Int {
        require(numberOfTry.isNumeric()) {
            NUMERIC_ERROR
        }

        return numberOfTry.toInt()
    }

    private fun String.isNumeric(): Boolean {
        return this.chars().allMatch { Character.isDigit(it) }
    }

    companion object {
        private const val NUMERIC_ERROR = "[ERROR] 시도 횟수는 숫자 입력으로만 받습니다."
    }
}
