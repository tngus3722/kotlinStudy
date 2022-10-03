package lecture10

interface Swimable {

    // 코틀린에서는 backing field가 없는 프로퍼티를 interface에 만들 수 있다
    val swimAbility: Int

    fun act() {
        println("어푸어푸")
    }
}