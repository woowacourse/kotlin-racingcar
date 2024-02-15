package racingcar.controller

class Race {
    private val outputView = OutputView()
    private val inputView = InputView()

    fun getNames(): List<String> {
        outputView.printCarNamesGuide()
        lateinit var names: List<String>

        while (true) {
            try {
                names = inputView.readCarNames().split(",")
                names.forEach { name ->
                    Car(name)
                }
                break
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }

        return names
    }
}
