package racing.domain

internal class TestEngine(private val value: Int) : Engine {
    override fun isMovable() = value >= Engine.THRESHOLD
}
