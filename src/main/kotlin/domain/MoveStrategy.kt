package domain

interface MoveStrategy {
    companion object {
        const val THRESHOLD = 4
    }

    fun canMove(): Boolean
}
