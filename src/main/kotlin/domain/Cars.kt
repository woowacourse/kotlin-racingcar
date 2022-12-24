package domain

class Cars private constructor(
    val items: List<Car>
) {
    init {
        val distinctCount = items.map { it.name }
            .distinct()
            .count()
        require(distinctCount == items.count()) { "자동차 이름은 중복될 수 없습니다." }
    }

    fun move(numberGenerator: NumberGenerator) {
        items.forEach { it.move(numberGenerator) }
    }

    companion object {
        fun fromNames(names: List<String>): Cars = Cars(names.map { Car(it) })
    }
}
