class Car(
    val name: String,
) {
    var distance: Int = 0
        private set

    fun move() {
        val random: Int = (0..9).random()
        if (isMovable(random)) {
            distance += 1
        }
        println("$name : ${displayDistance()}")
    }

    private fun displayDistance(): String {
        var output = ""
        repeat(distance) {
            output += "-"
        }
        return output
    }

    companion object {
        fun isMovable(random: Int): Boolean {
            // 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
            return random >= 4
        }
    }
}
