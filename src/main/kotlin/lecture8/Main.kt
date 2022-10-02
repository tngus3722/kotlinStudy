package lecture8

/**
 * 코틀린에서 함수를 다루는 방법
 */
fun main() {
    repeat("hello world")
    repeat("hello world", 5)
    repeat("hello world", 10, false)
    // named Parameter
    // 코틀린에서 자바 함수를 사용할 때는 사용할 수 없다
    repeat("hello world", userNewLine = false)


    printAll("A", "B", "C")

    // arrayOf는 배열을 만들어주며 Array타입은 자바에서 배열을 의미한다.
    var array:Array<String> = arrayOf("A", "B", "C")
    // 배열을 사용하는 경우 자바와 다르게 "*"를 통한 스프레드 연산자를 사용하여야한다.
    printAll(*array)
}

fun getMax(a: Int, b: Int): Int {
    return if (a > b) {
        a
    } else {
        b
    }
}

// 아래 처럼 사용할 수 있다.
// 단순 return 함수는 중괄호 생략, 타입추론으로 반환타입 생략 가능
fun getMax2(a: Int, b: Int) =
    if (a > b) {
        a
    } else {
        b
    }

// default parameter
fun repeat(str: String, num: Int = 3, userNewLine: Boolean = true) {
    for (i in 1..num) {
        if (userNewLine) {
            println(str)
        } else {
            print(str)
        }
    }
}

// 가변인자
fun printAll(vararg strs: String) {
    for (str in strs) {
        println(str)
    }
}