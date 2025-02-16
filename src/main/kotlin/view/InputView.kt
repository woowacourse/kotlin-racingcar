package view

class InputView {
    fun getUserInput(): String {
        val input = readln()
        validateInput(input)
        return input
    }

    private fun validateInput(input: String) {
        require(input.trim().isNotEmpty()) {
            "입력이 존재하지 않습니다."
        }
    }
}
