package lecture9

fun main() {
    val personKotlin: PersonKotlin9 = PersonKotlin9("정수현", 26)
    // getter
    println(personKotlin.name)
    println(personKotlin.age)

    // setter
    personKotlin.age = 30
    println(personKotlin.age)


    /**
     * 코틀린에서는 static 키워드가 없다
     * 이를 대체하기 위해서는 다양한 방법이 있다.
     * 1. top-level 에서 method, field를 사용한다.
     * 2. Companion Object를 사용한다.
     */
    // 정적메소드
    PersonKotlin9.printClassInfo()

    // 정적 팩토리 메소드
    val personJava: PersonJava9 = PersonJava9("soohyeon", 26)
    val personKotlin2 = PersonKotlin9.fromPersonJava9(personJava)

    println(personKotlin2.name)
    println(personKotlin2.age)
}