package racingCar

fun main() {
    val inputView = InputView()
    val outputView = OutputView()
    val judge = Judge()
    val raceGame = RaceGame(inputView, outputView, judge)
    raceGame.run()
}
