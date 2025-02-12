class Input {
    fun readCarNames(): List<Car> {
        val carNames = readln().split(",")
        require(carNames.size == carNames.toSet().size) { "[ERROR] 자동차 이름은 중복될 수 없습니다." }
        require(carNames.size > 1) { "[ERROR] 자동차가 한 대일 경우 경기가 취소됩니다." }
        return carNames.map { name ->
            Car(name)
        }
    }

    fun readRaceCount(): Int {
        val count = readln().toInt()
        require(count > 0) { "[ERROR] 자동차 경주는 0회 이상 이루어져야 합니다." }
        return count
    }
}
