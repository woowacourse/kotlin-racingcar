package model

import org.junit.jupiter.api.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class RacingGameTest {
    private lateinit var racingGame: RacingGame

    @BeforeEach
    fun setup(){
        racingGame = RacingGame()
    }

    @ParameterizedTest
    @ValueSource(strings = ["", " ", "car12345", "1", "car1, car1", "car1, car12345"])
    fun `자동차 생성 예외 테스트`(input: String){
        assertThrows<IllegalArgumentException> {  racingGame.generateCars(input) }
    }
}
