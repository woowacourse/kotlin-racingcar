fun main() {
    val inputReader = InputReader()
    val outputPrinter = OutputPrinter()

    val judge = Judge()
    val raceOrganizer = RaceOrganizer(inputReader, outputPrinter, judge)

    raceOrganizer.hostRace()
}
