package racingCar

fun main() {
    val inputView = InputView()
    val outputView = OutputView()
    val referee = Referee()
    val raceGame = RaceGame(inputView, outputView, referee)
    raceGame.run()
}
