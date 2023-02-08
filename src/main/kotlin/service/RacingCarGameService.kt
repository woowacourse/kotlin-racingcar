package service

class RacingCarGameService {
    fun isPossibleMove(): Boolean = RandomNumberGenerator().generate() >= 4
}
