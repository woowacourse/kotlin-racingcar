package racingcar

import racingcar.controller.GameController
import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val racingGame = GameController(scanner)
    racingGame.playGame()
}