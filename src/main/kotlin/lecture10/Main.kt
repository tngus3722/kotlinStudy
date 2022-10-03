package lecture10

/**
 * 코틀린에서 상속을 다루는 방법
 */
fun main() {

    val derived: Derived = Derived(300)
    val base: Base = Derived(150)

    val flyable: Flyable = Penguin("팽귄")
    flyable.act()
    flyable.fly()
}

open class Base(
    open val number: Int = 100
) {

    init {
        println("Base Class Init")
        // accessing non-final property number in constructor
        // 상위클래스의 constructor 혹은 init 클래스에서는 하위 클래스의 final이 아닌(하위에서 override한 프로퍼티)를 접근해서는 안된다.
        // 위와 같은 곳에서 사용하는 프로퍼티는 open 키워드를 붙이지 않아야한다.
        // 기본적으로 final 지시어가 (자바의 final과는 좀 결이 다른것 같다) 붙으면 필드, 메소드, 클래스에 대해서 상속 또는 override가 불가능 하다는 의미로 들어가며 이는 default로 붙어있는 키워드이다.
        println(this.number)
    }
}

class Derived(
    override val number: Int
) : Base(number) {

    init {
        println("Derived Class Init")
        println(number)
    }

}