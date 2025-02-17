package racingCar.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingCar.model.Cars

class CarsTest {
    private lateinit var cars: Cars

    @Test
    @DisplayName("자동차 이름이 존재하지 않으면, 예외가 발생한다.")
    fun carsNameNotExistTest() {
        assertThrows<IllegalArgumentException> {
            cars = Cars("")
        }
    }

    @Test
    @DisplayName("자동차 이름이 중복되면, 예외가 발생한다.")
    fun carsNameDuplicateTest() {
        assertThrows<IllegalArgumentException> {
            cars = Cars("오이,오이")
        }
    }

    @Test
    @DisplayName("자동차가 2대 미만이면, 예외가 발생한다.")
    fun carsLessThanTwoTest() {
        assertThrows<IllegalArgumentException> {
            cars = Cars("오이")
        }
    }

    @Test
    @DisplayName("자동차 이름을 입력하면, 자동차 객체 리스트가 생성된다.")
    fun carParsingTest() {
        val testInput = "오이,모찌"
        cars = Cars(testInput)
        assertEquals(cars.parsedCars.size, testInput.split(",").size)
        assertEquals(cars.parsedCars.first().name, "오이")
        assertEquals(cars.parsedCars.last().name, "모찌")
    }
}
