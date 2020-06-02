package racing.domain

interface Engine {
    companion object {
        const val THRESHOLD = 4
    }

    fun isMovable(): Boolean
}
