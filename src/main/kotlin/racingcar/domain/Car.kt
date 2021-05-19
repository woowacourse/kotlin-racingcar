package racingcar.domain

class Car(
    var position: Int = 0)
{
    fun move(strategy:MoveStrategy) {
        if(strategy.isMovable()){
            position += 1
        }
    }

}