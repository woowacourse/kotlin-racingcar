package racingCar.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class CarTest {

    @ParameterizedTest(name = "생성값이 4 이상이면 이동한다.")
    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    fun moveTest(number: Int) {
        //  given
        val generator: NumberGenerator = FixedNumberGenerator(number)
        val name = Name("test")
        val car = Car(name, generator)

        //  when
        car.move()

        //  then
        assertEquals(car.position, 1)
    }

    @ParameterizedTest(name = "생성값이 4 보다 작으면 그대로 있는다.")
    @ValueSource(ints = [1, 2, 3])
    fun stayTest(number: Int) {
        //  given
        val generator: NumberGenerator = FixedNumberGenerator(number)
        val name = Name("test")
        val car = Car(name, generator)

        //  when
        car.move()

        //  then
        assertEquals(car.position, 0)
    }
}
