package racingCar

class InputView {
    fun readRaceCars(): List<Car> {
        val carNames = readln().split(RACE_CAR_NAME_DIVIDER).map { it.trim() }
        CarError.validate(carNames)
        return carNames.map { name ->
            Car(name)
        }
    }

    fun readRaceCount(): Int {
        val raceCount = readln().trim()
        RaceCountError.validate(raceCount)
        return raceCount.toInt()
    }

    companion object {
        private const val RACE_CAR_NAME_DIVIDER = ","
    }
}
