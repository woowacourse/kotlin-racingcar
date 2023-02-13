package racingcar.racingcar.domain.raceresult

data class RaceResult(
    val result: List<StepResult>,
)

data class StepResult(
    val racers: List<RacerResult>,
)

data class RacerResult(
    val name: String,
    val location: Int,
)
