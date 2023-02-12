package dto

class CarNamesDTO(private val names: List<String>) {
    fun getCarNames(): List<String> {
        return names
    }
}
