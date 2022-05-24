import io.kotest.matchers.shouldBe
import io.kotest.assertions.throwables.*
import io.kotest.core.spec.style.AnnotationSpec

class CarTest : AnnotationSpec() {

    @Test
    fun `처음 생성한 자동차의 위치는 0`() {
        val car = Car("jason")
        car.position shouldBe 0
    }

    @Test
    fun `자동차 이름이 5자를 초과할 경우 예외를 던진다`() {
        var invalidName = "123456"

        shouldThrow<IllegalArgumentException> {
            Car(invalidName)
        }
    }
}