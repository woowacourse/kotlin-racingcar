package dto

data class CarNames(val input: String) {
    val carNamesList: List<String> = input.split(",").map { it.trim() }.filter { it.isNotBlank() }
}
