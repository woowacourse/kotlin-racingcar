class Car(
    val name: String,
    initialDistance: Int = 0,
) {
    var distance: Int = initialDistance
        private set

    fun move() {
        distance += 1
    }

    private fun displayDistance() {
        var prettyDistance = ""
        repeat(distance) { prettyDistance += "-" }
        println("$name : $prettyDistance")
    }
}
