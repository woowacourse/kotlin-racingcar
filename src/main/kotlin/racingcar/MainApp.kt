package racingcar

import racingcar.car.Car
import racingcar.input.InputView
import java.util.*
import kotlin.streams.toList

class MainApp {

}

fun main(){
    val inputView = InputView(Scanner(System.`in`))
    val inputLine = inputView.inputCarNames()
    println(inputLine)
}

// RacingGame으로 포장하기
fun playGame(){
    val inputView = InputView(Scanner(System.`in`))
    val inputLine = inputView.inputCarNames()

    val random = Random()

    // cars로 포장하기
    val cars = inputLine.split(",")
        .stream()
        .map { name -> Car(name) }
        .toList();

    cars.stream()
        .forEach{car -> car.tryToMove(random.nextInt(10))}
}