package lecture19

import lecture17.Fruit
/**
 * as import
 * 이름이 같은 함수나 메소드를 사용할 때 as 구문을 사용하여 구분해줄 수 있다.
 */
import lecture19.Fruit as Fruit2

/**
 * 19강 코틀린 이모저
 */

/**
 * type alias
 * 타입에 별칭을 줄 수 있다.
 */
typealias mapSSF = Map<String, Map<String, Fruit>>

fun main() {
    // type alias
    val fruitMap: mapSSF
    // as import
    val fruit: Fruit2

    /**
     * 구조분해
     * 복합적인 값을 분해하여 여러 변수를 한번에 초기화하는것
     * data class는 componentN 함수를 자동으로 만들어 준다.
     * 별로 쓸만한 기능은 아닌듯한데
     */
    val person: Person = Person("soohyeon", 26)
    val (name, age) = person
    // 아래와 같다
    // val name = person.component1()
    // val age = person.component2()
    println("이름 : ${name} 나이 : ${age}")

    val person2: Person2 = Person2("tngus", 26)
    val (name2, age2) = person2
    println("이름 : ${name2} 나이 : ${age2}")

    val numbers: List<Int> = listOf(1, 3, 4)

    /**
     * jump와 label
     * break, continue를 사용한다면 아래처럼 쓰지말고 그냥 for문 쓰자 걍
     * for에서도 걍 쓰지마
     */
    run {
        numbers.forEach { number ->
            if (number % 2 == 0) {
                return@run // break와 같다
            }
            if (number == 1 ) {
                return@forEach // continue와 같다
            }
            println(number)
        }
    }
    abc@ for (i in 1..100) {
        for (j in 1..100) {
            if (j == 2) {
                break@abc
            }
            println("${i}, ${j}")
        }
    }
}

data class Fruit(val name: String)


data class Person(val name: String, var age: Int)

class Person2(val name: String, var age: Int) {

    operator fun component1(): String {
        return this.name
    }

    operator fun component2(): Int {
        return this.age
    }
}

/**
 * takeIf
 * 주어진 조건을 만족하는 경우 값 그렇지 않다면 null을 반환하는 기능이다
 * 안쓸래
 */
fun getNumberOrNull(number: Int): Int? {
    return number.takeIf { number > 0 }
}

/**
 * takeUnless
 * takeIf의 반대
 */
fun getNumberOrNull2(number: Int):Int? {
    return number.takeUnless { number <= 0 }
}