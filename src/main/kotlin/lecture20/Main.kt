package lecture20

import lecture19.Person

/**
 * 20강 kotlin의 scope function
 *
 * 람다를 사용하여 일시적인 영역을 만들고 코드를 간결하게 만들거나 method chainning을 쉽게 하기 위해 사용한다.
 * let run also apply with 등이 있다.
 *
 * 아래 4개는 확장함수이다.
 * let, run은 람다의 결과를 반환한다.
 * also, apply는 객체 자체를 반환한다.
 *
 * let also 는 it을 사용한다.(생략 불가능, 다른 이름을 붙일 수 있다. 일반함수를 받는다.)
 * run, apply 는 this를 사용한다. (생략 가능, 다른 이름을 붙일 수 없다. 확장함수를 받는다.)
 *
 * with : this를 사용해 접근하고 생략 가능하다. 확장함수가 아니다.
 */
fun main() {
    printPerson(Person("tngus", 26))

    val strings = listOf("Apple", "Car");

    // 용례 1 method chaining을 위한 사용
    val after = strings.map { str -> str.length }
        .filter { length -> length > 1 }
        .let { lengths ->
            println(lengths)
            lengths
        }

    println(after)

    // 용례 2 non-null 인 경우에만 실행되도록
    val length: String? = "test"
    length?.let { println(length) }

    // 용례 3 객체 초기화와 반환값의 결과를 동시에 사용하는 경우
    val person = Person("tngus", 26).run { mockSave(this) }
    println(person)
    
}

fun printPerson(person: Person) {
    println(person.name)
    println(person.age)

    // let 은 scope function의 한 종류이다
    person.let {
        println(it.name)
        println(it.age)
    }

    val value1 = person.let { it.name } // name
    val value2 = person.run { this.age } // age
    val value3 = person.also { person -> person.age } // person
    val value4 = person.apply { age } // person
    with(person) {
        println(name)
    }
}

fun mockSave(person: Person): Person {
    println("saved")
    return person
}