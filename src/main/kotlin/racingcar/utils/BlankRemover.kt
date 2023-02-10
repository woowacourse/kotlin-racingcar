package racingcar.utils

object BlankRemover {
    fun removeBlank(texts: MutableList<String>) {
        for (i in texts.indices) {
            texts[i] = removeBlank(texts[i])
        }
    }

    private fun removeBlank(text: String): String = text.trim()
}
