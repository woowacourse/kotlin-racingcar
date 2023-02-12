package utils

class CarNamesValidator : Validator {
    override fun validate(input: String) {
        val names = input.split(',')

        verifyCarCount(names)
        verifyCarUniqueness(names)
        names.map { name ->
            verifyName(name)
            verifyNameLength(name)
        }
    }

    private fun verifyCarCount(names: List<String>) {
        require(names.size in 2..20) { "$ERROR_CAR_COUNT\n잘못된 입력값 : ${names.joinToString(",")}" }
    }

    private fun verifyCarUniqueness(names: List<String>) {
        require(names.size == names.distinct().size) { "$ERROR_CAR_UNIQUENESS\n잘못된 입력값 : ${names.joinToString(",")}" }
    }

    private fun verifyName(name: String) {
        name.map {
            require(it.code in 97..122) { "$ERROR_NAME\n잘못된 입력값 : $name" }
        }
    }

    private fun verifyNameLength(name: String) {
        require(name.length in 1..5) { "$ERROR_NAME_LENGTH\n잘못된 입력값 : $name" }
    }

    companion object {
        const val ERROR_CAR_COUNT = "자동차 개수는 2대 이상 20대 이하여야 합니다."
        const val ERROR_CAR_UNIQUENESS = "자동차 이름은 중복되면 안 됩니다."
        const val ERROR_NAME = "자동차 이름은 공백이 없는 영문 소문자여야 합니다."
        const val ERROR_NAME_LENGTH = "자동차 이름은 1글자 이상 5글자 이하여야 합니다."
    }
}
