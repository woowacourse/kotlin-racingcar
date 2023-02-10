package racingcar.domain

import org.junit.jupiter.api.BeforeEach

class RacingCarTest {

    private lateinit var car: RacingCar

    @BeforeEach
    fun init() {
        car = RacingCar("name")
    }
}
