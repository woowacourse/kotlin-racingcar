package dto

class WinnersDTO(private val winners: List<String>) {
    fun getWinners(): List<String> {
        return winners
    }
}
