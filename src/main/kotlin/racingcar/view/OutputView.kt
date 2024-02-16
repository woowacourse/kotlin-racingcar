package racingcar.view

class OutputView {
    fun printFinalWinners(finalWinners: List<String>){
        print(finalWinners.joinToString(","))
    }
}
