class InputView {
    fun inputCarNames(): List<Car> {
        val input = readLine()
        val names = input!!.split(",").toList()
        val cars = mutableListOf<Car>()
        for (name in names) {
            cars.add(Car(name, 0))
        }
        return cars.toList()
    }

    fun inputTryNumber(): String? {
        return readLine()
    }
}
