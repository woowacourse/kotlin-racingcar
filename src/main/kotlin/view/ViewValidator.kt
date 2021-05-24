package view

class ViewValidator {
    fun validNumMatch(numMatch: String?): Int {
        return numMatch?.toInt() ?: 0
    }

    fun validCarNames(inputNumCar: String?): String {
        return inputNumCar ?: ""
    }
}
