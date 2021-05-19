package racingcar.domain.name

class Name(name: String) {
    private val name: String;

    init {
        validateName(name)
        this.name = name;
    }

    private fun validateName(name: String) {
        if (name.isBlank()) {
            throw IllegalArgumentException("이름은 빈 문자열일 수 없습니다.")
        }

        if (name.length > 5) {
            throw IllegalArgumentException("이름은 5글자 초과일 수 없습니다.")
        }
    }

    fun name(): String {
        return name
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Name
        if (name != other.name) return false
        return true
    }

    override fun hashCode(): Int {
        return name.hashCode()
    }
}