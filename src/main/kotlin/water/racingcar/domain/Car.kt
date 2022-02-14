package water.racingcar.domain

class Car(val name: String) {
    var movedValue: Int = 0
        private set

    fun move(randomNumber: Int) {
        if (randomNumber >= 4)
            movedValue++
    }

    override fun toString(): String {
        val output = StringBuilder()
        var moved = movedValue

        output.append("$name : ")
        while (moved > 0) {
            output.append("-")
            moved--
        }
        return output.toString()
    }
}