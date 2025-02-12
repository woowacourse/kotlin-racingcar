class Racing {
    val inputView = InputView()
    val outputView = OutputView()

    fun play() {
        val cars = getCars(inputView.readCars())
        val attempts = getAttempts(inputView.readAttempt())
        race(cars, attempts)
        val winners = getWinners(cars)
        outputView.printRaceWinner(winners)
    }

    fun getCars(carsInput: String): List<Car> {
        val carsName = carsInput.split(",")
        carsName.forEach {
            require(it.length < 5) { "[ERROR]: 자동차 이름은 5자를 내외입니다." }
        }
        return carsName.map { carName -> Car(carName.trim()) }
    }

    fun getAttempts(attempts: String): Int = requireNotNull(attempts.toIntOrNull()) { "[ERROR]: 시도 횟수를 입력해주세요." }

    fun race(
        cars: List<Car>,
        attempts: Int,
    ) {
        outputView.printResultTitle()
        repeat(attempts) {
            cars.forEach { car ->
                car.move()
            }
            outputView.printCarState(cars)
        }
    }

    fun getWinners(cars: List<Car>): List<Car> {
        val maxPosition = cars.maxOf { car -> car.position }
        return cars.filter { car -> car.position == maxPosition }
    }
}
