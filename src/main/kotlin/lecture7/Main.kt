package lecture7

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

/**
 * 코틀린에서 예외를 다루는 방법
 */
fun main() {
    println(tryCatchFinal("30"))
    checkedException()
    tryWithResource("./a.txt")
}

/**
 * try-catch-final
 * try-catch도 if-else와 같이 하나의 expression으로 간주된다.
 */
fun tryCatchFinal(str: String): Int {

    try {
        return str.toInt()
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException("주어진 문자열이 숫자가 아닙니다")
    }
}

/**
 * try-catch도 if-else와 같이 하나의 expression으로 간주된다.
 */
fun tryCatchFinal2(str: String): Int? {

    return try {
        str.toInt()
    } catch (e: NumberFormatException) {
        null
    }
}

/**
 * checkedException
 * 코틀린에서는 checked Exception을 구분되지 않는다. 딱히 throws를 붙여주지 않아도 된다.
 */
fun checkedException() {
    val currentFile = File(".")
    val file = File(currentFile.absolutePath + "/a.txt")
    val reader = BufferedReader(FileReader(file))
    println(reader.readLine())
    reader.close();
}

/**
 * try-with-resources
 * 코틀린에서는 없다 대신 use라는 inline 확장 함수를 사용한다. 이후에 자세히 다룬다
 */
fun tryWithResource(path: String) {
    BufferedReader(FileReader(path)).use { reader ->
        println(reader.readLine())
    }
}