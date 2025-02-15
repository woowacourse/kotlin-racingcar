fun main() {
    val inputValidator = InputValidator()
    val inputReader = InputReader(inputValidator)

    val outputPrinter = OutputPrinter()

    val judge = Judge()
    val raceOrganizer = RaceOrganizer(inputReader, outputPrinter, judge)

    raceOrganizer.hostRace()
}
