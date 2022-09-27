package lecture1

/**
 * 1강 코틀린에서 변수를 다루는 방법
 */
fun main() {

    /**
     *  in Java
     *
     *  long value = 1L
     *  final long value2 = 1L
     *
     *  Long value3 = 1L
     *  final Long value4 = 1L
     *  Long value4 = null
     */

    var value = 1L // long value = 1L
    val value2 = 1L // final long value2 = 1L
    var value3: Long = 1L // Long value3 = 1L
    val value4: Long = 1L // final Long value4 = 1L
    var value5: Long? = null

    // var value5 error! 타입추론 불가

    var value6: Long
    // println(value6) error! 선언은 가능하지만 초기화전에 사용 불가

    var value7: Long?
    // println(value7) error! nullable 변수도 초기화전에 사용 불가

    var value8: Long? = null
    println(value8) // 가능
}
