package model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class CarTest {
    @Test
    fun `true를 받으면 1칸 전진한다`() {
        val car = Car("aa", 0)
        car.moveForward(true)
        assertThat(car.position).isEqualTo(1)
    }

    @Test
    fun `carA 와 carB의 위치가 같으면 isSamePosition 함수는 true를 반환한다`() {
        val carA = Car("aa", 0)
        val carB = Car("bb", 0)
        assertThat(carA.isSamePosition(carB)).isTrue()
    }

    @Test
    fun `숫자가 4 이상이면 true를 반환한다`() {
        val car = Car("aa", 0)
        assertThat(car.isPossibleMove(5)).isEqualTo(true)
    }

    @Test
    @DisplayName("aa차량을 3번 전진시키고 현재 상태를 출력하면 \"aa : ---\" 을 출력한다")
    fun getPresentStatus() {
        val car = Car("aa", 0)
        car.moveForward(true)
        car.moveForward(true)
        car.moveForward(true)
        assertThat(car.getPresentStatus()).isEqualTo("aa : ---")
    }
}
