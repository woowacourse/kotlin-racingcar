class Car(private val name: String, private var position: Int = 0) {

    init {
        Validator().checkName(name)
    }

    fun getInfo(): Pair<String, Int> {
        return Pair(name, position)
    }

    fun move(random: Int) {
        if (random >= 4) position++
    }
}
