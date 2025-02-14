fun main() {
    val inputValidator = InputValidator()
    val inputReader = InputReader(inputValidator)

    val outputPrinter = OutputPrinter()

    val judge = Judge()
    val organizer = Organizer(inputReader, outputPrinter, judge)

    organizer.hostRace()
}
