import generator.NumberGenerator
import generator.RandomNumberGenerator
import model.Car
import model.Cars
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarsTest {

    private val inputCars = listOf(Car("pobi"), Car("woni"), Car("gugu"))
    private val tryNumber = 3

    @Test
    fun `자동차 이름들 ','로 구분되어 생성되었는지 확인`() {
        val mappingCars = Cars.mappingCars("pobi,woni,gugu", RandomNumberGenerator())
        assertThat(mappingCars.cars[0].name).isEqualTo(inputCars[0].name)
        assertThat(mappingCars.cars[1].name).isEqualTo(inputCars[1].name)
        assertThat(mappingCars.cars[2].name).isEqualTo(inputCars[2].name)
    }

    @Test
    fun `자동차 경주 우승자들 확인`() {
        val cars = Cars(inputCars, TestNumberGenerator())
        repeat(tryNumber) { cars.move() }
        assertThat(cars.findWinners()).isEqualTo(listOf("pobi", "gugu"))
    }

    class TestNumberGenerator : NumberGenerator {
        val testNumber = listOf(4, 1, 6)
        var position = 0
        override fun generate(): Int {
            return testNumber[position++ % 3]
        }
    }
}
