package exception

class Validator {
    fun checkCarName(input: String): List<String> {
        val names = input.split(",")
        for (name in names) {
            if (name.length > 5) {
                throw IllegalArgumentException("[ERROR] 5자를 초과할 수 없습니다.")
            }
            if (name.isEmpty()) {
                throw IllegalArgumentException("[ERROR] 올바른 입력 형식이 아닙니다.")
            }
        }
        return names
    }

    fun checkRoundCount(input: String): Int {
        return input.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] 숫자가 아닙니다.")
    }
}
