package racingcar.racingcar.domain.raceresult

data class RaceResult(
    val names: List<String>,
    val result: List<StepResult>,
)

data class StepResult(
    val locations: List<Int>,
)
