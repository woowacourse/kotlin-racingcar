package racecar.view

import racecar.domain.RaceCar

class KernelRaceCarGameOutputView : RaceCarGameOutputView {
    override fun outputRaceResultTitle() = println("실행 결과")

    override fun outputRacingStatus(cars: List<RaceCar>) {
        println(formatToRacingStatus(cars))
    }

    override fun outputErrorMessage(errorMessage: String) = println(errorMessage)

    override fun outputWinners(winner: List<RaceCar>) = print(winner.formatToWinners())

    private fun formatToRacingStatus(winners: List<RaceCar>) =
        buildString {
            winners.forEach { append("${it.formatToStatus()}\n") }
        }

    private fun List<RaceCar>.formatToWinners() = "최종 우승자: ${joinToString { it.name }}"

    private fun RaceCar.formatToStatus(): String = "$name : ${DISTANCE_UNIT.repeat(position)}"

    companion object {
        private const val DISTANCE_UNIT = "-"
    }
}
