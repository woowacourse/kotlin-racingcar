package model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class RacingTest {


    @ParameterizedTest
    @CsvSource("2,0","3,0","4,1","5,1")
    fun `한 라운드에서, Car 객체의 moveForward 메서드가 모두 동작했는지 검증 테스트`(randomNumber: Int, forwardCount: Int) {
        val racing = Racing(listOf("가나","다라","마바")) { randomNumber }
        racing.move()
        assertThat(racing.cars.all { it.forwardCount == forwardCount }).isTrue

    }


    @Test
    fun `최종 우승자 반환 테스트`() {
        val racing = Racing(listOf("가나", "다라")) { 1 }
        racing.cars.forEachIndexed { index, car ->
            car.moveForward(isMoveExample[index])
        }
        assertThat(racing.getWinners()).isEqualTo(listOf("가나"))
    }

    companion object {

        val isMoveExample = listOf(true, false)
    }
}
