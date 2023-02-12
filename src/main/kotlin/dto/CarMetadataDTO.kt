package dto

class CarMetadataDTO(
    private val distance: Int,
    private val name: String
) {
    fun getDistance(): Int {
        return distance
    }

    fun getName(): String {
        return name
    }
}
