package lecture12

/**
 * 코틀린에서 object 키워드를 다루는 방법
 */
fun main() {

    val person: Person = Person.newBaby("soohyeon")
    println(person.name)
    println(person.age)


    println("=================")
    println(SingleTone.a)
    SingleTone.a += 10

    println(SingleTone.a)

    // 익명 클래스
    println("=================")
    moveSomeThing(object: Movable {
        override fun move() {
            println("움직인다")
        }

        override fun fly() {
            println("날아간다")
        }
    })
}

// 코틀린에서 정적 메소드, 정적 필드를 클래스안에 만드는 방법
class Person private constructor(var name: String, var age: Int) {

    // static 키워드 대신 companion object에서 선언한다.
    companion object Factory : Log {
        // const 키워드를 붙여야 compile 시 변수가 할당된다. 진짜진짜 상수에 붙일 때 사용한다.
        private const val MIN_AGE = 1

        // java 에서 사용할 때 static 처럼 사용하기 위해서 붙이는 어노테이션
        @JvmStatic
        fun newBaby(name: String): Person {
            return Person(name, MIN_AGE)
        }

        // interface 구현 가능하다.
        override fun log() {
            println("override in companion object ")
        }
    }
}

// 코틀린에서의 싱글톤클래스를 만드는 방법
object SingleTone {
    var a: Int = 0
}


private fun moveSomeThing(movable: Movable) {
    movable.move()
    movable.fly()
}