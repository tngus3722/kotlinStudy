package lecture5

/**
 * 코틀린에서 조건문을 다루는 방법
 */
fun main() {

}

fun ifTest(score: Int) {
    if (score > 0) {
        throw IllegalArgumentException("${score}는 0보다 작을 수 없습니다")
    }
}

// 코틀린에서는 if-else 구문이 statement로 취급된다. (마치 삼항연산자처럼)
// 따라서 삼항연산자가 필요가 없어 존재하지 않는다.
fun ifTest2(score: Int): String {
    return if (score >= 50) {
        "P"
    } else {
        "F"
    }
}

fun ifTest3(score: Int): String {
    return if (score >= 90) {
        "A"
    } else if (score >= 60) {
        "B"
    } else {
        return "C"
    }
}

fun ifTest4(score: Int) {
    if (score in 0..100) {
        println("someThing")
    }
}

// switch-case 문은 사라졌으며 when을 사용한다, statement로 취급된다.
fun switchTest(score: Int): String {
    return when (score) {
        in 90..99 -> "A"
        in 80..89 -> "B"
        in 70..79 -> "C"
        else -> "F"
    }
}

// 조건절에는 어떤 expression도 들어갈 수 있다.
fun switchTest2(obj: Any): Boolean {
    return when (obj) {
        is String -> obj.startsWith("A")
        else -> false
    }
}


// 조건절에서 여러개의 조건을 검사할 수 있다.
fun switchTest3(number: Int) {
    when (number) {
        1, 0, -1 -> println("어디서 많이 본 숫자")
        else -> println("어디서 본 숫자가 아니다")
    }
}

// when절에 값을 주지 않아도 된다.
fun switchTest4(number: Int) {
    when {
        number == 0 -> println("zero")
        number % 2 == 0 -> println("even")
        else -> println("odd")
    }
}

