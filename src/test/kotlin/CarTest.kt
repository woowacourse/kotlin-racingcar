import model.Car
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class CarTest {

    @DisplayName("차의 현재 상태를 잘 출력하는지 확인하는 테스트")
    @CsvSource("testCar1,3,testCar1 : ---", "testCar2,2,testCar2 : --")
    @ParameterizedTest
    fun testCarPresentStatus(name: String, position: Int, expected: String) {
        val actual = Car(name, position).getPresentStatus()
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `4이상이면 전진한다`() {
        val car = Car("test", 0)
        val isPossibleMove = car.isPossibleMove(4)
        car.moveForward(isPossibleMove)
        assertThat(car.getPresentStatus()).isEqualTo("test : -")
    }

    @Test
    fun `4 미만이면 움직이지 않는다`() {
        val car = Car("test", 0)
        val isPossibleMove = car.isPossibleMove(1)
        car.moveForward(isPossibleMove)
        assertThat(car.getPresentStatus()).isEqualTo("test : ")
    }
}
