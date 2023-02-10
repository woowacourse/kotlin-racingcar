package racingcar.utils

object TextUtils {
    fun removeTextsBlank(names: List<String>): List<String> {
        return names.map { it.trim() }.toList()
    }
}
