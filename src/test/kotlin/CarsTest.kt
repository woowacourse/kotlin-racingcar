import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import racingcar.domain.Car
import racingcar.domain.Cars
import racingcar.util.RandomGenerator

class CarsTest {
    private val randomGenerator = RandomGenerator()

    @Test
    fun `주어진 자동차 목록에서 가장 많이 전진한 우승자의 이름을 반환한다`() {
        val car1 = Car(name = "제이슨", position = 4)
        val car2 = Car(name = "디노", position = 3)
        val car3 = Car(name = "레아", position = 2)
        val car4 = Car(name = "제임스", position = 1)

        val cars = Cars(listOf(car1, car2, car3, car4), randomGenerator)

        val winnerNames = cars.getWinnerNames()
        Assertions.assertEquals(listOf("제이슨"), winnerNames)
    }

    @Test
    fun `주어진 자동차 목록에서 가장 많이 전진한 여러 명의 우승자의 이름들을 반환한다`() {
        val car1 = Car(name = "제이슨", position = 4)
        val car2 = Car(name = "디노", position = 4)
        val car3 = Car(name = "레아", position = 4)
        val car4 = Car(name = "제임스", position = 4)

        val cars = Cars(listOf(car1, car2, car3, car4), randomGenerator)

        val winnerNames = cars.getWinnerNames()
        Assertions.assertEquals(listOf("제이슨", "디노", "레아", "제임스"), winnerNames)
    }
}
