package model

data class RaceResult(val round: Int, val carStates: List<CarState>)

data class CarState(val name: String, val position: Int) {
    companion object {
        fun from(car: Car): CarState {
            return CarState(car.name, car.position)
        }
    }
}
