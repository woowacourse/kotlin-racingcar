package racingcar.controller

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class ExceptionHandlingTest {
    lateinit var exceptionHandling: ExceptionHandling
    @BeforeEach
    fun setup(){
        exceptionHandling = ExceptionHandling()
    }
}