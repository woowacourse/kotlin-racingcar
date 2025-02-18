package domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import racingcar.domain.model.Car
import racingcar.domain.service.CarWinnersService

class CarWinnersServiceTest {
    private lateinit var carWinnersService: CarWinnersService

    @BeforeEach
    fun setUp() {
        carWinnersService = CarWinnersService(listOf(Car("동전"), Car("제리"), Car("제이든")))
    }

    @ParameterizedTest
    @MethodSource("getWinners")
    fun `위치가 제일 높은 자동차들을 반환하는 기능 테스트`(
        carWinnersService: CarWinnersService,
        actual: List<Car>,
    ) {
        assertThat(actual).isEqualTo(carWinnersService.getWinners())
    }

    companion object {
        @JvmStatic
        fun getWinners(): List<Arguments> {
            return listOf(
                Arguments.arguments(
                    CarWinnersService(listOf(Car("동전", 3), Car("제리", 6), Car("제이든", 7))),
                    listOf(Car("제이든", 7)),
                ),
                Arguments.arguments(
                    CarWinnersService(listOf(Car("동전", 3), Car("제리", 4), Car("제이든", 4))),
                    listOf(Car("제리", 4), Car("제이든", 4)),
                ),
            )
        }
    }
}
