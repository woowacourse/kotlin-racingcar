class Racing {
    val inputView = InputView()
    val outputView = OutputView()

    fun play() {
        val cars = getCars(inputView.readCars())
        val attempts = getAttempts(inputView.readAttempt())
        race(cars, attempts)
        outputView.printRaceWinner(cars)
    }

    fun getCars(carsInput: String): List<Car> {
        val carsName = carsInput.split(",")
        carsName.forEach {
            require(it.length < 5) { "[ERROR]: 자동차 이름은 5자를 내외입니다." }
        }
        return carsName.map { carName -> Car(carName.trim()) }
    }

    fun getAttempts(attempts: String): Int = requireNotNull(attempts.toIntOrNull()) { "[ERROR]: 시도 횟수를 입력해주세요." }

    fun race(cars: List<Car>, attempts: Int) {
        outputView.printResultTitle()
        repeat(attempts) {
            cars.forEach { car ->
                car.move()
            }
            outputView.printCarState(cars)
        }
    }
}