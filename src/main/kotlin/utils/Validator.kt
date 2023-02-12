package utils

interface Validator<T> {
    fun validate(input: String): T
}
