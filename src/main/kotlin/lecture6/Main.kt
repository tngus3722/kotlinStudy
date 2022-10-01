package lecture6

/**
 * 코틀린에서 반복문을 다루는 방법
 */
fun main() {
    forEach()
    forTest()
}

/**
 * 향상된 for문
 */
fun forEach() {
    var numbers: List<Long> = listOf(1L, 2L, 3L)

    for(number in numbers) {
        println(number)
    }
}

/**
 * 전통적인 for문
 * 나중에 step, downTo같은 중위함수에 대해서 다룬다
 */
fun forTest() {

    for(i in 1..10) {
        print("${i} ")
    }

    println()

    for(i in 10 downTo 1) {
        print("${i} ")
    }

    println()

    for(i in 1..5 step 2) {
        print("${i} ")
    }
}

/**
 * while, do-while은 동일하므로 생략
 */