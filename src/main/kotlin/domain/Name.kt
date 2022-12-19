package domain

class Name(
    val value: String
) {
    init {
        require(value.isNotEmpty() && value.length <= 5) {
            "자동차 이름은 1자 이상, 5자 이하여야 합니다."
        }
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
