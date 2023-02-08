package service

class RacingCarGameService {
    fun isPossibleMove(): Boolean = RandomNumberGenerator().generate() >= 4

    fun splitCarNames(carNames: String): List<String> = carNames.split(",")
}
