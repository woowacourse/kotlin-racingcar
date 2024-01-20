package domain

import io.kotest.matchers.collections.shouldBeSameSizeAs
import io.kotest.matchers.collections.shouldExist
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
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


    @DisplayName("우승한 차량들 검증")
    @Test
    fun winnerCarsTest() {
        val gamingCars = GamingCars(listOf(Car("Benz", 1), Car("포르쉐", 2), Car("람보르기", 2)))

        val winnerCars: List<Car> = gamingCars.calcWinnerCars();

        winnerCars.size shouldBe 2
        winnerCars shouldExist { car: Car -> car.distance == 2 }
        winnerCars shouldExist { car: Car -> car.distance != 1 }
        winnerCars shouldExist { car: Car -> car == Car("포르쉐", 2) }
        winnerCars shouldExist { car: Car -> car == (Car("람보르기", 2)) }
    }
}