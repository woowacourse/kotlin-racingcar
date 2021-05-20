package racingcar.domain

const val MINIMUM_NAME_LENGTH = 5;

class Name(name: String) {

    private val value: String;

    init {
        validate(name.trim())
        this.value = name.trim();
    }

    private fun validate(name: String) {
        if (name.isBlank()) {
            throw IllegalArgumentException("이름은 빈 문자열일 수 없습니다.")
        }

        if (name.length > MINIMUM_NAME_LENGTH) {
            throw IllegalArgumentException("이름은 5글자 초과일 수 없습니다.")
        }
    }

    fun value(): String {
        return value
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Name
        if (value != other.value) return false
        return true
    }

    override fun hashCode(): Int {
        return value.hashCode()
    }
}