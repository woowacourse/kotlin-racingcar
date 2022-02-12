package water.racingcar.code

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.collections.shouldContainAll
import io.kotest.matchers.shouldBe
import water.racingcar.GameConsoleInput
import kotlin.collections.ArrayList

internal class GameConsoleInputKtTest : BehaviorSpec ({
    val game = GameConsoleInput()

    given("게임 시작시 유저에게"){
        val emptyInput = "" as String?
        `when` ("빈 문자열을 입력받으면") {
            then("빈 배열을 반환한다."){
                game.getListOfNames(emptyInput) shouldBe emptyList
            }
        }

        val namesInput = "name1,name2,name3" as String?
        `when`("5자 이하의 이름들을 쉼표로 구분하여 입력받으면"){
            then("이름을 담은 배열을 반홭한다."){
                val result = game.getListOfNames(namesInput)
                result.size shouldBe 3
                result shouldContainAll listOf("name1","name2","name3")
            }
        }

        val longName = "too Long" as String?
        `when`("5자 이상의 이름을 입력받으면"){
            then("빈 배열을 반환한다."){
                game.getListOfNames(longName) shouldBe emptyList
            }
        }
        val containsLongName = "short, good, tooLong"
        `when`("5자 이상의 이름이 하나 이상 입력되면"){
            then("빈 배열을 반환한다."){
                game.getListOfNames(longName) shouldBe emptyList
            }
        }

        val wrongTypeInput ="wrong111"
        `when`("횟수를 입력받을 때 숫자가 아닌 값이 입력되면"){
            then("null 을 반환한다."){
                game.getNumberOfTimes(wrongTypeInput) shouldBe null
            }
        }
        val correctTypeInput = "111"
        `when`("횟수를 입력받을 때 숫자가 입력되면"){
            then("숫자 값을 반환한다."){
                game.getNumberOfTimes(correctTypeInput) shouldBe 111
            }
        }
    }
}){
    companion object {
        private val emptyList = ArrayList<String>()
    }
}