package water.racingcar.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

internal class CarTest : BehaviorSpec({

    given("random 값이 주어졌을 때"){
        val smallRandomValue = 1

        `when` ("값이 4 미만인 경우 ") {
            then("멈춘다."){
                car.move(smallRandomValue)
                car.movedValue shouldBe 0
            }
        }

        val bigRandomValue = 4
        `when` ("값이 4 이상일 경우 ") {
            then("전진한다."){
                car.move(bigRandomValue)
                car.movedValue shouldBe 1
            }
        }
    }

    given("Car 을 출력할 때"){
        val carPrintSample = Car("name")
        // 2번 이동한다.
        carPrintSample.move(5)
        carPrintSample.move(5)
        `when`("움직인 값이 2라면") {
            then ("이름과 전진한 만큼 '-'를 사용하여 출력한다."){
                carPrintSample.toString() shouldBe "${carPrintSample.name} : --"
            }
        }
    }
}) {
    companion object {
        val car = Car("nameTest")
    }
}
