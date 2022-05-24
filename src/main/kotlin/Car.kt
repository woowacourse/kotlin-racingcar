class Car(name: String) {
    val name: String
    val position = 0

    init {
        require(name.length <= 5)
        this.name = name
    }
}