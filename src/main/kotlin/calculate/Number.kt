package calculate

data class Number(val value: Int) {

    constructor(value: String) : this(value.toInt()) {
        println("들어온 값 value = $value")
        if (value.isNullOrEmpty() || value.isBlank()) {
            println("이거이거 문제가 있구만")
            throw IllegalArgumentException("입력값에 null 또는 공백 및 빈 문자열을 입력할 수 없습니다")
        }
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
