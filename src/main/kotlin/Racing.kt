class Racing {
    val inputView = InputView()
    fun play() {
        val cars = getCars(inputView.readCars())
        val attempts = getAttempts(inputView.readAttempt())
    }

    fun getCars(carsInput: String): List<Car> {
        val carsName = carsInput.split(",")
        carsName.forEach {
            require(it.length < 5) { "[ERROR]: 자동차 이름은 5자를 내외입니다."  }
        }
        return carsName.map { carName -> Car(carName.trim()) }
    }

    fun getAttempts(attempts: String) = requireNotNull(attempts.toIntOrNull()) { "[ERROR]: 시도 횟수를 입력해주세요." }

    fun race(cars: List<Car>) {
        
    }
}