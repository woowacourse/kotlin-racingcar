class InputReader(
    private val inputValidator: InputValidator,
) {
    fun readRaceCars(): List<Car> {
        val carNames = readln().split(RACE_CAR_NAME_DIVIDER)
        inputValidator.validateApplicantCars(carNames)

        return carNames.map { name ->
            inputValidator.validateCarName(name)
            Car(name)
        }
    }

    fun readRaceCount(): Int {
        val count = readln().toInt()
        inputValidator.validateRaceCount(count)
        return count
    }

    companion object {
        private const val RACE_CAR_NAME_DIVIDER = ","
    }
}
