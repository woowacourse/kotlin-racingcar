package racingcar.racingcar.domain.raceresult

class RaceResultMapper {
    fun toRaceResultDto(raceResult: RaceResult): RaceResultDto {
        return RaceResultDto(
            names = raceResult.names,
            result = raceResult.result,
        )
    }
}
