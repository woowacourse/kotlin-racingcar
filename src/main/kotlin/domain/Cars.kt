package domain

import java.util.Collections.max

class Cars private constructor(
    val items: List<Car>
) {
    val winners: List<Car>
        get() {
            val maxPosition = max(items.map { it.position })
            return items.filter { it.isLocatedAt(maxPosition) }
        }

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
