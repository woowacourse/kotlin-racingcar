import car.Car
import car.Cars
import view.dto.PositionsDto
import view.dto.RoundDto

private const val DEFAULT_THRESHOLD = 4;

class RacingGame(numberOfCars: String?, numberOfRounds: String?) {
    private val rounds: Int
    private val cars: Cars

    init {
        validate(numberOfCars, numberOfRounds)
        this.cars = Cars((1..numberOfCars!!.toInt()).map { Car(DEFAULT_THRESHOLD) })
        this.rounds = numberOfRounds!!.toInt()
    }

    fun playGame(): RoundDto {
        val positionsDtos: MutableList<PositionsDto> = mutableListOf()
        for (i in (1..rounds)) {
            cars.moveAll()
            positionsDtos.add(cars.getPositionsDto())
        }
        return RoundDto(positionsDtos)
    }

    private fun validate(numberOfCars: String?, numberOfRounds: String?) {
        if (numberOfCars.isNullOrBlank() || numberOfRounds.isNullOrBlank()) {
            throw IllegalArgumentException("값을 입력하셔야합니다.")
        }
        if (numberOfCars.isNotDigit() || numberOfRounds.isNotDigit()) {
            throw NumberFormatException("양의 정수만 입력해주세요.")
        }
    }
}

fun String.isNotDigit(): Boolean = this.any { !it.isDigit() }
