class CarRacing(
    private val inputView: InputView = InputView()
) {

    fun makeCars(): List<Car> {
        val names = inputView.inputCarNames().split(',')

        return names.map { name ->
            Car(0, name)
        }
    }
}
