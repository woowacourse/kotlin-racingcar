package racingcar.domain.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.assertThrows
import racingcar.domain.NumberGenerator

class CarsTest {
    @Test
    @DisplayName("자동차 이름이 존재하지 않으면, 예외가 발생한다.")
    fun carsNameNotExistTest() {
        val exception =
            assertThrows<IllegalArgumentException> {
                Cars(listOf(""))
            }
        assertEquals("자동차 이름에 빈 값이 입력되었습니다.", exception.message)
    }

    @Test
    @DisplayName("자동차 이름이 중복되면, 예외가 발생한다.")
    fun carsNameDuplicateTest() {
        val duplicateCarNames = listOf("오이", "오이")
        val exception =
            assertThrows<IllegalArgumentException> {
                Cars(duplicateCarNames)
            }
        assertEquals("자동차 이름 중 중복이 존재합니다.: $duplicateCarNames", exception.message)
    }

    @Test
    @DisplayName("자동차가 2대 미만이면, 예외가 발생한다.")
    fun carsLessThanTwoTest() {
        val notEnoughCarNames = listOf("오이")
        val exception =
            assertThrows<IllegalArgumentException> {
                Cars(notEnoughCarNames)
            }
        assertEquals("자동차가 2대 미만 입력되었습니다.: $notEnoughCarNames", exception.message)
    }

    @Test
    @DisplayName("자동차 이름을 입력하면, 자동차 객체 리스트가 생성된다.")
    fun carParsingTest() {
        val testInput = listOf("오이", "모찌")
        val cars = Cars(testInput)
        assertAll(
            { assertEquals(cars.parsedCars.size, testInput.size) },
            { assertEquals(cars.parsedCars.first().name, "오이") },
            { assertEquals(cars.parsedCars.last().name, "모찌") },
        )
    }

    @Test
    @DisplayName("난수가 4 이상이면 라운드 종료 후, 자동차가 한 칸 전진한다.")
    fun playOneRoundTest() {
        val numberGenerator =
            object : NumberGenerator {
                override fun generate(): Int = 4
            }
        val cars = Cars(listOf("test1", "test2"), numberGenerator)
        val movedCar = Car("movedCar", Car.INIT_POSITION + 1)
        cars.playOneRound()
        assertAll(
            { assertEquals(cars.parsedCars.first().position, movedCar.position) },
            { assertEquals(cars.parsedCars.last().position, movedCar.position) },
        )
    }

    @Test
    @DisplayName("난수가 4 미만이면 라운드 종료 후, 자동차가 전진하지 않는다.")
    fun playOneRoundNotProgressTest() {
        val numberGenerator =
            object : NumberGenerator {
                override fun generate(): Int = 3
            }
        val cars = Cars(listOf("test1", "test2"), numberGenerator)
        val stopCar = Car("stopCar")
        cars.playOneRound()
        assertAll(
            { assertEquals(cars.parsedCars.first().position, stopCar.position) },
            { assertEquals(cars.parsedCars.last().position, stopCar.position) },
        )
    }

    @Test
    @DisplayName("가장 멀리 이동한 자동차가 유일한 경우, 우승자가 1명 출력된다.")
    fun singleWinnerTest() {
        val carNames = listOf("test1", "test2")
        val cars = Cars(carNames)
        cars.parsedCars.first().moveForward(Car.MINIMUM_MOVE_POINT)
        assertEquals(cars.getWinner(), carNames.first())
    }

    @Test
    @DisplayName("가장 멀리 이동한 자동차가 여럿인 경우 공동 우승자가 된다.")
    fun multipleWinnerTest() {
        val numberGenerator =
            object : NumberGenerator {
                override fun generate(): Int = 4
            }
        val carNames = listOf("test1", "test2")
        val cars = Cars(carNames, numberGenerator)
        cars.playOneRound()
        assertEquals(cars.getWinner(), carNames)
    }
}
