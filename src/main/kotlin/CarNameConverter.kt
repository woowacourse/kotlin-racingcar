import domain.cars.Cars.Companion.CAR_NAME_DELIMITER

object CarNameConverter {
    fun convert(input: String): List<String> {
        return input.split(CAR_NAME_DELIMITER).map { it.trim() }
    }
}
