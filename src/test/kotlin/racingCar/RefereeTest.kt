package racingCar

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class RefereeTest {
    private val referee = Referee()
    private val car1 = Car("제이슨")
    private val car2 = Car("디노")
    private val car3 = Car("레아")
    private val car4 = Car("제임스")

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3])
    fun `랜덤 숫자가 4 미만인 경우 false 를 반환한다`(randomNumber: Int) {
        assertFalse(referee.isCarAbleToMove(randomNumber))
    }

    @ParameterizedTest
    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    fun `랜덤 숫자가 4 이상인 경우 true 를 반환한다`(randomNumber: Int) {
        assertTrue(referee.isCarAbleToMove(randomNumber))
    }

    @Test
    fun `주어진 자동차 목록에서 가장 많이 전진한 우승자의 이름을 반환한다`() {
        repeat(4) { car1.moveForward(true) }
        repeat(3) { car2.moveForward(true) }
        repeat(2) { car3.moveForward(true) }
        repeat(1) { car4.moveForward(true) }

        val cars = listOf(car1, car2, car3, car4)

        val winnerNames = referee.selectWinnerNames(cars)

        Assertions.assertEquals(listOf("제이슨"), winnerNames)
    }

    @Test
    fun `주어진 자동차 목록에서 가장 많이 전진한 여러 명의 우승자의 이름들을 반환한다`() {
        repeat(4) { car1.moveForward(true) }
        repeat(4) { car2.moveForward(true) }
        repeat(4) { car3.moveForward(true) }
        repeat(4) { car4.moveForward(true) }

        val cars = listOf(car1, car2, car3, car4)

        val winnerNames = referee.selectWinnerNames(cars)

        Assertions.assertEquals(listOf("제이슨", "디노", "레아", "제임스"), winnerNames)
    }
}
