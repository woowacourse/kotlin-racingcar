import generator.NumberGenerator
import generator.RandomNumberGenerator
import model.Car
import model.Cars
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CarsTest {

    private val inputCars = listOf(Car("pobi"), Car("woni"), Car("gugu"))
    private val tryNumber = 3

    @Test
    fun `자동차 이름이 중복된 경우 예외 테스트`() {
        assertThrows<IllegalArgumentException> {
            Cars.mappingCars("pobi, woni, pobi", RandomNumberGenerator())
        }
    }

    @Test
    fun `입력된 자동차의 수가 2대 이상 20대 이하가 아닌 경우 예외 테스트`() {
        assertThrows<IllegalArgumentException> {
            Cars.mappingCars("pobi", RandomNumberGenerator())
        }
    }

    @Test
    fun `자동차 이름들 ','로 구분되어 생성되었는지 확인`() {
        val mappingCars = Cars.mappingCars("pobi,woni,gugu", RandomNumberGenerator())
        assertThat(mappingCars.cars[0].name).isEqualTo(inputCars[0].name)
        assertThat(mappingCars.cars[1].name).isEqualTo(inputCars[1].name)
        assertThat(mappingCars.cars[2].name).isEqualTo(inputCars[2].name)
    }

    @Test
    fun `자동차 경주 우승자가 없는 경우 확인`() {
        val cars = Cars(listOf(Car("pobi"), Car("woni"), Car("gugu")), TestNumberGenerator())
        repeat(tryNumber) {
            cars.cars[0].move(0)
            cars.cars[1].move(0)
            cars.cars[2].move(0)
        }
        assertThat(cars.findWinners().size).isEqualTo(0)
    }

    @Test
    fun `자동차 경주 우승자들 확인`() {
        val cars = Cars(listOf(Car("pobi"), Car("woni"), Car("gugu")), TestNumberGenerator())
        repeat(tryNumber) {
            cars.cars[0].move(4)
            cars.cars[1].move(1)
            cars.cars[2].move(6)
        }
        assertThat(cars.findWinners()).isEqualTo(listOf("pobi", "gugu"))
    }

    class TestNumberGenerator : NumberGenerator {
        private val testNumber = listOf(4, 1, 6)
        private var idx = 0
        override fun generate(): Int {
            return testNumber.get(idx++)
        }
    }
}
