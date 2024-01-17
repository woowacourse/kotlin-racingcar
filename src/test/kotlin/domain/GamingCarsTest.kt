package domain

import io.kotest.matchers.shouldNotBe
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class GamingCarsTest {

    @DisplayName("게임할 차량들 생성 검증")
    @Test
    fun gamingCarTest() {
        val gamingCars = GamingCars(listOf(Car("Benz"), Car("포르쉐"), Car("람보르기")))

        gamingCars shouldNotBe null
    }
}