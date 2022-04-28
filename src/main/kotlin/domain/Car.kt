package domain

data class Car(val name: String, var position: Int = 0) {

    fun move(isMovable: Boolean){
        if (isMovable){
            position++;
        }
    }
}
