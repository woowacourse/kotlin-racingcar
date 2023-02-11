import data.Car
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarTest {

    @ParameterizedTest
    @ValueSource(strings = ["우아한테크코스", "배달의 민족", "만세만세만만세", " "])
    fun `유효하지 않은 자동차 이름 확인하기`(name: String) {
        assertThrows<IllegalArgumentException> {
            Car(name)
        }
    }
}
