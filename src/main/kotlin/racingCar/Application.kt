package racingCar

fun main() {
    val inputView = InputView()
    val outputView = OutputView()
    val judge = Judge()
    val organizer = Organizer(inputView, outputView, judge)
    organizer.hostRace()
}
