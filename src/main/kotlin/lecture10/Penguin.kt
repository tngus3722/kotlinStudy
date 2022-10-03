package lecture10

class Penguin(
    species: String
) : Animal(species, 2), Swimable, Flyable {

    private val wingCount: Int = 2

    override fun move() {
        println("펭귄이 움직인다")
    }

    override val legCount: Int
        get() = super.legCount + this.wingCount

    // 중복되는 인터페이스를 특정할 때 자바와 차이점
    // java => JavaSwimable.super.act()
    // kotlin => <Swimable>.act()
    override fun act() {
        super<Flyable>.act()
        super<Swimable>.act()
    }

    override fun fly() {
        println("훨훨")
    }

    override val swimAbility: Int
        get() = 3
}