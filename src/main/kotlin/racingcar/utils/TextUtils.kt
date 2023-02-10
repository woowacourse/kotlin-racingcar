package racingcar.utils

abstract class TextUtils {

    companion object {
        fun removeTextsBlank(names: List<String>): List<String> {
            return names.map { it.trim() }.toList()
        }
    }
}
