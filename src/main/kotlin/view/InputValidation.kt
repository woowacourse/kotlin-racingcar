package view

fun InputView.validTryCount(input: String) {
    if (input.toIntOrNull() == null || input.toInt() < 0) {
        throw IllegalArgumentException("시도 횟수는 0이상의 정수여야 합니다.")
    }
}