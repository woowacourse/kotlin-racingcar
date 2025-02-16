import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class JudgeTest {
    private val judge = Judge()

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3])
    fun `랜덤 숫자가 4 미만인 경우 false 를 반환한다`(randomNumber: Int) {
        assertFalse(judge.isCarAbleToMove(randomNumber))
    }

    @ParameterizedTest
    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    fun `랜덤 숫자가 4 이상인 경우 true 를 반환한다`(randomNumber: Int) {
        assertTrue(judge.isCarAbleToMove(randomNumber))
    }

    @Test
    fun `주어진 자동차 목록에서 가장 많이 전진한 우승자의 이름을 반환한다`() {
        val car1 = Car(name = "제이슨", position = 4)
        val car2 = Car(name = "디노", position = 3)
        val car3 = Car(name = "레아", position = 2)
        val car4 = Car(name = "제임스", position = 1)

        val cars = listOf(car1, car2, car3, car4)

        val winnerNames = judge.selectWinnerNames(cars)

        Assertions.assertEquals(listOf("제이슨"), winnerNames)
    }

    @Test
    fun `주어진 자동차 목록에서 가장 많이 전진한 여러 명의 우승자의 이름들을 반환한다`() {
        val car1 = Car(name = "제이슨", position = 4)
        val car2 = Car(name = "디노", position = 4)
        val car3 = Car(name = "레아", position = 4)
        val car4 = Car(name = "제임스", position = 4)

        val cars = listOf(car1, car2, car3, car4)

        val winnerNames = judge.selectWinnerNames(cars)

        Assertions.assertEquals(listOf("제이슨", "디노", "레아", "제임스"), winnerNames)
    }
}
