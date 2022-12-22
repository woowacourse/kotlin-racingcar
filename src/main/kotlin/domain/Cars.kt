package domain

class Cars(
    val items: List<Car>
) {
    constructor(vararg names: String) : this(names.map { Car(it) })

    init {
        val distinctCount = items.map { it.name }
            .distinct()
            .count()
        require(distinctCount == items.count()) { "자동차 이름은 중복될 수 없습니다." }
    }

    fun move(numberGenerator: NumberGenerator) {
        items.forEach { it.move(numberGenerator) }
    }
}
