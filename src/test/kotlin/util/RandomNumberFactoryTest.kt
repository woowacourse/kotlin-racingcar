package util

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.RepeatedTest
import kotlin.random.Random

class RandomNumberFactoryTest {

    @DisplayName("0 ~ 9 까지 랜덤 숫자를 얻는 Random 기능 테스트 100회 반복")
    @RepeatedTest(100)
    fun randomNumberTest() {
        var randomNumber: Int = Random.nextInt(0, 9)

        assertThat(randomNumber).isLessThanOrEqualTo(9)
        assertThat(randomNumber).isGreaterThanOrEqualTo(0)
    }

    @DisplayName("0 ~ 9 까지 랜덤 숫자를 얻는 Random 기능 테스트 100회 반복2")
    @RepeatedTest(100)
    fun randomNumberTest2() {
        var randomNumber: Int = (0..9).random()

        assertThat(randomNumber).isLessThanOrEqualTo(9)
        assertThat(randomNumber).isGreaterThanOrEqualTo(0)
    }

    @DisplayName("0 ~ 9 까지 랜덤 숫자를 얻는 factory create 테스트 100회 반복")
    @RepeatedTest(100)
    fun makeNumberTest() {
        var randomNumber: Int = RandomNumberFactory.create()

        assertThat(randomNumber).isLessThanOrEqualTo(9)
        assertThat(randomNumber).isGreaterThanOrEqualTo(0)
    }
}