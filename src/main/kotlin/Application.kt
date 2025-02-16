fun main() {
    val inputReader = InputReader()
    val outputPrinter = OutputPrinter()

    val raceOrganizer = RaceOrganizer(inputReader, outputPrinter)

    raceOrganizer.hostRace()
}
