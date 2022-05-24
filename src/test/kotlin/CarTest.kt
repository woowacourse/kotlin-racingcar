import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class CarTest {

    @Test
    fun `처음 생성한 자동차의 위치는 0`() {
        val car = Car("awesomeo")
        car.position shouldBe 0
    }
}