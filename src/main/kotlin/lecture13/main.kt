package lecture13

/**
 * 코틀린에서 중첩함수를 다루는 방법
 */
fun main() {

}

class KotlinHome(
    val address: String,
    val livingRoom: LivingRoom
) {


    // 기본적으로 static inner class로 만들어진다.
    class LivingRoom(area: Double) {
        private val area: Double = area
    }


    // 단순 inner 클래스인 경우 inner 키워드를 붙여주어야 한다.
    inner class LivingRoom2(
        val area: Double
    ) {
        val address: String
            get() = this@KotlinHome.address
    }
}