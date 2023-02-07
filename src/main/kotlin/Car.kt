class Car(private val name: String, private var position: Int) {

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
