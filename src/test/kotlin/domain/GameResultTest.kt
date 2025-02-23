package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class GameResultTest {
    @Test
    @DisplayName("GameResult 객체는 car 이름과 거리를 입력받으면 이름 : -- 의 형식으로 변환한다")
    fun t1() {
        val gameResult = GameResult()
        gameResult.appendCar("car", 2)
        assertThat(gameResult.toString()).isEqualTo("car : --\n")
    }

    @Test
    @DisplayName("breakLine메서드는 내부적으로 줄바꿈을 수행한다")
    fun t2() {
        val gameResult = GameResult()
        gameResult.appendCar("car", 2)
        gameResult.breakLine()
        assertThat(gameResult.toString()).isEqualTo("car : --\n\n")
    }
}
