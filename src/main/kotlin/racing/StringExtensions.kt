package racing

fun String.toOnlyIntOrNull(): Int? {
    if (this.contains(".")) return null
    return this.toIntOrNull()
}
