package model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class RandomNumberTest {

    @Test
    fun `랜덤 숫자 생성 기능 테스트`(){
        repeat(100){
            val randomNumber = RandomNumber().generate()
            assertThat(randomNumber in 0..9).isTrue()
        }
    }
}
