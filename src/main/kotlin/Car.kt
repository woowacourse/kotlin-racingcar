class Car(val name: String) {
    var distance: Int = 0
        private set

    fun move() {
        if (isMovable()) {
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

    private fun isMovable(): Boolean {
        // 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
        val random: Int = (0..9).random()
        return random >= 4
    }
}