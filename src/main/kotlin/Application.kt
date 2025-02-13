fun main() {
    val inputReader = InputReader()
    val outputPrinter = OutputPrinter()
    val judge = Judge()
    val organizer = Organizer(inputReader, outputPrinter, judge)
    organizer.hostRace()
}
