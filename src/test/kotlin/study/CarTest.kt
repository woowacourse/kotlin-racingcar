package study

import org.junit.jupiter.api.Test

class Car1(
    private val name: String,
)

class Car2(
    val name: String,
)

class CarTest {
    @Test
    fun `자동차 객체의 접근제어자의 디컴파일 setter 확인을 위한 테스트 코드`() {
        val car1 = Car1("ㅎㅇ")
        val car2 = Car2("ㅎㅇ")
    }
}
