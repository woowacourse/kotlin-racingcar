package racingcar.model

class Car(val name: String){
    var position: String = ""
        private set
    private fun decideMovement(randomNumber: Int): Boolean = randomNumber in moveIfInThisRange

    fun moveCar(randomNumber: Int){
        if (decideMovement(randomNumber)){
            position += "-"
        }
    }
    companion object{
        val moveIfInThisRange = 4..9
    }
}
