import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import racingcar.domain.Car
import racingcar.domain.Cars
import racingcar.domain.strategy.NumberGenerator

@DisplayName("자동차들의 ")
class CarsTest {

    @DisplayName("한 번에 이동시킬 수 있다")
    @Test
    fun moveAll1() {
        val cars = Cars.from(listOf("test1", "test2", "test3"))

        cars.moveAll(AlwaysMovedGenerator())

        assertThat(cars.cars).allMatch({ car -> car.getPosition() == 1 })
    }

    @DisplayName("숫자가 이동 가능 범위 안에 있지않으면 정지한다")
    @Test
    fun moveAll2() {
        val cars = Cars.from(listOf("test1", "test2", "test3"))

        cars.moveAll(NeverMovedGenerator())

        assertThat(cars.cars).allMatch { car -> car.getPosition() == 0 }
    }

    @DisplayName("승자를 구할 수 있다")
    @Test
    fun getWinners1() {
        val car1 = Car.of("test1", 1)
        val car2 = Car.of("test2", 1)
        val car3 = Car.of("test3", 3)
        val car4 = Car.of("test4", 3)
        val cars = Cars(listOf(car1, car2, car3, car4))

        val winners = cars.getWinners()

        assertThat(winners).containsExactly(car3, car4)
    }

    class AlwaysMovedGenerator : NumberGenerator {

        override fun generate(): Int {
            return 4
        }
    }

    class NeverMovedGenerator : NumberGenerator {

        override fun generate(): Int {
            return 0
        }
    }
}
