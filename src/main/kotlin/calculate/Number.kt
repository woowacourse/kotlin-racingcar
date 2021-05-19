package calculate

data class Number(private val value: Int) {

    constructor(value: String) : this(value.toInt()) {
        require(!value.isNullOrBlank())
    }

    fun add(target: Number): Number {
        return Number(this.value + target.value)
    }

    fun subtract(target: Number): Number {
        return Number(this.value - target.value)
    }

    fun multiply(target: Number): Number {
        return Number(this.value * target.value)
    }

    fun divide(target: Number): Number {
        if (target.value == 0) {
            throw IllegalArgumentException("0으로 나누는 연산은 할 수 없습니다")
        }
        return Number(this.value / target.value)
    }

}
