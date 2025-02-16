package model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CarsTest {
    private lateinit var cars: Cars

    @Test
    @DisplayName("자동차 이름이 존재하지 않으면, 예외가 발생한다.")
    fun carsNameNotExistTest() {
        val exception =
            assertThrows<IllegalArgumentException> {
                cars = Cars(listOf(""))
            }
        assertEquals("자동차 이름에 빈 값이 입력되었습니다.", exception.message)
    }

    @Test
    @DisplayName("자동차 이름이 중복되면, 예외가 발생한다.")
    fun carsNameDuplicateTest() {
        val exception =
            assertThrows<IllegalArgumentException> {
                cars = Cars(listOf("오이", "오이"))
            }
        assertEquals("자동차 이름 중 중복이 존재합니다.", exception.message)
    }

    @Test
    @DisplayName("자동차가 2대 미만이면, 예외가 발생한다.")
    fun carsLessThanTwoTest() {
        val exception =
            assertThrows<IllegalArgumentException> {
                cars = Cars(listOf("오이"))
            }
        assertEquals("자동차 이름이 5자를 초과하였습니다.", exception.message)
    }

    @Test
    @DisplayName("자동차 이름을 입력하면, 자동차 객체 리스트가 생성된다.")
    fun carParsingTest() {
        val testInput = listOf("오이", "모찌")
        cars = Cars(testInput)
        assertEquals(cars.parsedCars.size, testInput.size)
        assertEquals(cars.parsedCars.first().name, "오이")
        assertEquals(cars.parsedCars.last().name, "모찌")
    }

    @Test
    @DisplayName("난수가 4 이상이면 라운드 종료 후, 자동차가 한칸 전진한다.")
    fun playOneRoundTest() {
        val moveGenerator =
            object : NumberGenerator {
                override fun generate(): Int = 4
            }
        cars = Cars(listOf("test1", "test2"), moveGenerator)
        cars.playOneRound()
        cars.parsedCars.forEach { car ->
            assertEquals(car.position, Car.INIT_POSITION + 1)
        }
    }

    @Test
    @DisplayName("난수가 4 미만이면 라운드 종료 후, 자동차가 전진하지 않는다.")
    fun playOneRoundNotProgressTest() {
        val moveGenerator =
            object : NumberGenerator {
                override fun generate(): Int = 3
            }
        cars = Cars(listOf("test1", "test2"), moveGenerator)
        cars.playOneRound()
        cars.parsedCars.forEach { car ->
            assertEquals(car.position, Car.INIT_POSITION)
        }
    }

    @Test
    @DisplayName("가장 멀리 이동한 자동차가 유일한 경우, 우승자가 1명 출력된다.")
    fun singleWinnerTest() {
        cars = Cars(listOf("test1", "test2"))
        cars.parsedCars[0].moveForward(4)
        assertEquals(cars.getWinner(), listOf("test1"))
    }

    @Test
    @DisplayName("가장 멀리 이동한 자동차가 여럿인 경우 공동 우승자가 된다.")
    fun multipleWinnerTest() {
        cars = Cars(listOf("test1", "test2"))
        cars.parsedCars.forEach { car ->
            car.moveForward(4)
        }
        assertEquals(cars.getWinner(), listOf("test1", "test2"))
    }
}
