import Constants.CAR_NAME_DELIMITER
import domain.cars.Car

object CarsArgumentConverter {
    fun toCarList(input: String): List<Car> {
        return input.split(CAR_NAME_DELIMITER).map { Car(it.trim()) }
    }
}
