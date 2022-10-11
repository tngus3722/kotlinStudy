package lecture16

/**
 * 16강 코틀린에서 다양한 함수를 다루는 방법
 */
fun main() {

    val test: String = "test";
    println(test.lastChar())
    val train: Train = Train("test")
    train.isExpensive()
    val srt1: Train = Srt("test")
    srt1.isExpensive()
    // override 는 현재 타입으로 기준으로 불린다.
    val srt2: Srt = Srt("test")
    srt2.isExpensive()

    val a: Int = 30
    val b: Int = 30
    println(a.add(b))
    println(a add2 b)
    println(a.add3(b))
}

/**
 * 확장함수
 *
 * 기존 자바 코드위에 자연스럽게 코드를 추가하기 위한 요구사항으로 만들어진 함수
 * 클래스 밖에 있지만 마치 클래스의 맴버함수처럼 사용할 수 있도록 한다.
 * {확장하려는 클래스}.{함수이름}(파라미터) : {반환타입}
 * this는 이용해 실제 클래스 안에 (public만) 접근할 수 있다.
 * signature가 같은 경우 멤버함수가 우선적으로 호출된다.
 */
fun String.lastChar(): Char {
    return this[this.length - 1]
}

open class Train(val name: String)

fun Train.isExpensive() {
    println("train expensive")
}

class Srt(name: String) : Train(name)

fun Srt.isExpensive() {
    println("srt expensive")
}


/**
 * 중위함수
 *
 * 그저 함수를 부르는 방식의 차이일 뿐이다.
 * infix 키워드를 통해 사용할 수 있다.
 *
 */
fun Int.add(other: Int): Int {
    return this + other
}

infix fun Int.add2(other: Int): Int {
    return this + other
}

/**
 * inline 함수
 *
 * 함수를 호출하는 대신에 함수 본문을 그대로 복붙하여 삽입한다.
 * 함수를 파라미터로 전달할 때 오버해드를 줄이기 위해 사용한다.
 * 근데 난 안쓸래 구려
 * C++에 있었던 것 같은데..?
 */
inline fun Int.add3(other: Int): Int {
    return this + other
}

/**
 * 지역함수
 *
 * 함수안에 함수가 있다.
 * 굳이 사용할까 싶긴한디
 */

fun getFullName(firstName: String, lastName: String): String {

    fun validateName(name: String) {
        if (name.isEmpty()) {
            throw IllegalArgumentException("name is null")
        }
    }

    validateName(firstName)
    validateName(lastName)

    return firstName + lastName
}