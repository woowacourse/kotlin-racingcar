package water.racingcar

import water.racingcar.domain.Car
import water.racingcar.dto.InputDto
import water.racingcar.ui.GameConsoleInput
import water.racingcar.util.RandomGenerator

class GameApplication(input: InputDto) {
    private val cars = input.carNames.map { Car(it) }.toList()
    private val randomGenerator: RandomGenerator = RandomGenerator();
    var times = input.times // 값은 외부에 공개하지만 클래스 외부에서 값을 변경할 수 없다.
        private set

    // 주어진 횟수 동안 각 라운드(전진 혹은 멈춤)을 진행하고 완료 후 우승자를 출력한다.
    fun playGame() {
        while (times > 0) {
            times--
            playEachRound()
        }
        printTotalResult()
    }

    // 각 라운드를 진행하고(전진 혹은 멈춤) 전진 상태를 출력한다.
    private fun playEachRound() {
        for (car in cars) {
            car.move(randomGenerator.generateRandomNumber())
        }
        printEachRound()
    }

    // 우승자 출력, 공동 우승이면 여러 명을 출력한다.
    private fun printTotalResult() {
        val maxMovedValue = cars.maxBy { it.movedValue }?.movedValue
        val winners = cars.filter { it.movedValue == maxMovedValue }.map { it.name }.toList()

        val winnerNames = winners.joinToString(separator = ", ")
        println("${winnerNames}가 최종 우승했습니다.")
    }

    private fun printEachRound() {
        val output = StringBuilder()
        for (car in cars)
            output.append("$car\n")
        println("$output")
    }
}

fun main() {
    val consoleInput = GameConsoleInput()
    val inputDto = consoleInput.getInputs()
    val gameApplication = GameApplication(inputDto)
    gameApplication.playGame()
}