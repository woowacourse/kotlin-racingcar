package racingcar

import racingcar.car.Car
import racingcar.car.Cars
import racingcar.input.InputView
import java.util.*
import kotlin.streams.toList

class MainApp {

}

fun main(){
    val inputView = InputView(Scanner(System.`in`))
    val inputLine = inputView.inputCarNames()
    println(inputLine)

    playGame()
}

// RacingGame으로 포장하기
fun playGame(){
    val inputView = InputView(Scanner(System.`in`))
    val carNames = inputView.inputCarNames()
    val carList = carNames.stream().map { name -> Car(name) }.toList()

    val cars = Cars(carList)
    cars.moveCars()

    val findWinner = cars.findWinner()
}