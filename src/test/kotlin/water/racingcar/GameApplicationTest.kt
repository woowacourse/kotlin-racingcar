package water.racingcar

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import water.racingcar.dto.InputDto


internal class GameApplicationTest: BehaviorSpec ({
        val gameApplication = GameApplication(inputDto)

        given("사용자 입력으로 차 이름 리스트와 이동 횟수가 주어졌을 때"){
            `when`("주어진 횟수만큼 라운드를 진행하여"){
                then("게임이 완료된 후 남은 횟수는 0이 된다."){
                    gameApplication.playGame()
                    gameApplication.times shouldBe 0
                }
            }
        }
}) {
    companion object {
        val inputDto = InputDto(carNames = listOf("name1","name2"), times = 5)
    }
}