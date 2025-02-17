package racing.domain.generator.anonymous

interface AnonymousNumberStrategy {
    fun getNumber(excludeNumbers: Set<Int>): Int
}
