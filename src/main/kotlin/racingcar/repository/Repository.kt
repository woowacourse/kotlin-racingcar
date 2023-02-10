package racingcar.repository

interface Repository<T> {
    fun selectAll(): List<T>
    fun insert(item: T)
}
