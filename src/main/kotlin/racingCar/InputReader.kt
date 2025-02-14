package racingCar

class InputReader {
    fun readRaceCars(): List<Car> {
        val carNames = readln().split(RACE_CAR_NAME_DIVIDER).map { it.trim() }
        require(carNames.size == carNames.toSet().size) { "[ERROR] 자동차 이름은 중복될 수 없습니다." }
        require(carNames.size >= MIN_RACE_CAR_COUNT) { "[ERROR] 자동차가 ${MIN_RACE_CAR_COUNT}대 이상일 경우에만 경기가 시작됩니다." }
        return carNames.map { name ->
            Car(name)
        }
    }

    fun readRaceCount(): Int {
        val count = readln().toIntOrNull() ?: throw IllegalArgumentException("[ERROR] 자동차 경주 횟수는 ")
        require(count >= MIN_RACE_COUNT) { "[ERROR] 자동차 경주는 ${MIN_RACE_COUNT}회 이상 이루어져야 합니다." }
        return count
    }

    companion object {
        private const val RACE_CAR_NAME_DIVIDER = ","
        private const val MIN_RACE_CAR_COUNT = 2
        private const val MIN_RACE_COUNT = 1
    }
}
