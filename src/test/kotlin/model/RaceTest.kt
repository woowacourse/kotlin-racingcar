package model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import racingCar.model.Car
import racingCar.model.Cars
import racingCar.model.NumberGenerator

class RaceTest {
    private lateinit var cars: Cars

    @BeforeEach
    fun setup() {
        cars = Cars("test1,test2")
    }

    @Test
    @DisplayName("난수가 4이상이면 라운드 종료 후, 자동차가 한칸 전진한다.")
    fun playOneRoundTest() {
        val moveGenerator =
            object : NumberGenerator {
                override fun generate(): Int = 4
            }
        cars.parsedCars.forEach { car ->
            assertEquals(car.getPosition(), Car.INIT_POSITION + 1)
        }
    }

    @Test
    @DisplayName("난수가 4미만이면 라운드 종료 후, 자동차가 전진하지 않는다.")
    fun playOneRoundNotProgressTest() {
        val moveGenerator =
            object : NumberGenerator {
                override fun generate(): Int = 3
            }
        cars.parsedCars.forEach { car ->
            assertEquals(car.getPosition(), Car.INIT_POSITION)
        }
    }

    @Test
    @DisplayName("가장 멀리 이동한 자동차가 유일한 경우, 우승자가 1명 출력된다.")
    fun singleWinnerTest() {
        cars.parsedCars[0].moveForward()
        assertEquals(cars.getWinner(), listOf("test1"))
    }

    @Test
    @DisplayName("가장 멀리 이동한 자동차가 여럿인 경우 공동 우승자가 된다.")
    fun multipleWinnerTest() {
        cars.parsedCars.forEach { car ->
            car.moveForward()
        }
        assertEquals(cars.getWinner(), listOf("test1", "test2"))
    }
}
