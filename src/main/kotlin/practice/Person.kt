package practice

class Person(val name: String, val age: Int? = 0, var nickname: String? = null) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Person

        if (name != other.name) return false
        if (age != other.age) return false
        if (nickname != other.nickname) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + (age ?: 0)
        result = 31 * result + (nickname?.hashCode() ?: 0)
        return result
    }
}