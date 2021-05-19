package racingcar

import racingcar.input.InputView
import java.util.*

class MainApp {

}

fun main(){
    val inputView = InputView(Scanner(System.`in`))
    val inputLine = inputView.inputCarNames()
    println(inputLine)
}