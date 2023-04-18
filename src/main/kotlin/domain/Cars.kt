package domain

private const val MIN_SIZE = 2

class Cars(names: List<String>) {

    val cars: List<Car>

    init {
        validate(names)
        this.cars = names.map { name -> Car(Name(name)) }
    }

    private fun validate(names: List<String>) {
        validateSize(names)
        validateNameDuplication(names)
    }

    private fun validateSize(names: List<String>) {
        if (names.size < MIN_SIZE) {
            throw IllegalArgumentException("자동차는 최소 " + MIN_SIZE + "대입니다")
        }
    }

    private fun validateNameDuplication(names: List<String>) {
        val nonDuplicateNames = HashSet<String>(names)
        if (nonDuplicateNames.size != names.size) {
            throw IllegalArgumentException("중복되는 이름이 존재합니다")
        }
    }

    fun findWinners(): List<Car> {
        val maxPosition = findMaxPosition()
        return cars.filter { it.isSamePosition(maxPosition) }
    }

    private fun findMaxPosition(): Int {
        return cars.maxOf { it.position.value }
    }

    fun moveCars(numberGenerator: NumberGenerator) {
        cars.forEach { car -> car.move(numberGenerator) }
    }
}
