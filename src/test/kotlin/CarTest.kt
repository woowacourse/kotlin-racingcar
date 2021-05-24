import controller.Winner
import domain.Car
import domain.Cars
import exception.InvalidCarNameException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import view.ViewValidator

class CarTest {
    @DisplayName("자동차 이름이 공백인 경우")
    @Test
    fun blankCarName() {
        assertThrows<InvalidCarNameException> {
            Car("", 0)
        }
    }

    @DisplayName("자동차의 거리를 입력하지 않은 경우")
    @Test
    fun noCarDistanceParameter() {
        val car = Car("car1")
        assertThat(car.distance).isEqualTo(0)
    }

    @DisplayName("자동차가 움직이는 경우")
    @Test
    fun carMove() {
        val car = Car("car1")
        car.move()
        assertThat(car).isEqualTo(Car("car1", 1))
    }

    @DisplayName("자동차의 거리값으로 null이 오는 경우")
    @Test
    fun nullCarDistance() {
        val car = Car("car1", null)
        assertThat(car).isEqualTo(Car("car1", 0))
    }

    @DisplayName("자동차 이름이 여러개가 오고 올바르지 않은 값인 경우")
    @Test
    fun invalidNames() {
        val inputNames = "test1, test2, test3 ,tes tt"

        assertThrows<InvalidCarNameException> {
            inputNames.split(",").map { Car(it, 0) }
        }
    }

    @DisplayName("우승자가 여러명인 경우")
    @Test
    fun printWinners() {

        val car1 = Car("winner1", 10)
        val car2 = Car("winner2", 10)
        val car3 = Car("loser", 5)

        val cars = Cars(listOf(car1, car2, car3))
        print(assertThat(Winner(cars).findWinnerNames()).hasSize(2))
    }

    @DisplayName("반복 횟수가 null 인 경우")
    @Test
    fun nullMatchCount() {
        val viewValidator = ViewValidator()

        assertThat(viewValidator.validNumMatch(null)).isEqualTo(0)
    }

    @DisplayName("반복 횟수가 숫자가 아닌 경우")
    @Test()
    fun exceptionMatchCount() {
        val viewValidator = ViewValidator()
        assertThrows<NumberFormatException> {
            viewValidator.validNumMatch("TEST")
        }
    }
}
