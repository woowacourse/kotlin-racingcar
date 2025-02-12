class Input {
    fun readCarNames(): List<Car> {
        val carNames = readln().split(",")
        require(carNames.size == carNames.toSet().size) { "[ERROR] 자동차 이름은 중복될 수 없습니다." }

        return carNames.map { name ->
            Car(name)
        }
    }
}
