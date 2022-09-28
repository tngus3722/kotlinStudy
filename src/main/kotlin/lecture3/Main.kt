package lecture3

/**
 * 코틀린에서 타입을 다루는 방법
 */
fun main() {
    val person = Person("정수현", 26)
    typeCasting(person)
    typeCastingWithNullable(null)
    unitReturn()
    stringInKotlin(person)
}

/**
 * 기본 자료형
 */
fun basicType() {
    var number1 = 3; // Int
    var number2 = 3L; // Long
    var number3 = 3.0f // float
    var number4 = 3.0 // double

    // 코틀린은 암시적 형변환을 하지 않는다
    number2 = number1.toLong();
    // 실수로
    println(number1 / number2.toDouble())

    // Nullable <-> notNull
    var number5: Int? = 3
    var number6: Long = number5?.toLong() ?: 0
}

/**
 * 타입캐스팅
 */
fun typeCasting(obj: Any) {

//    in Java
//    if (obj instanceof Person) {
//        Person person = (Person) obj;
//        System.out.println(person.getAge());
//    }
    


    // as Person 생략가능
    // context를 분석해서 smartCasting을 지원한다.
    if (obj is Person) {
        val person = obj as Person
        println(person.age)
    } else if (obj !is Person) {
        println("not Person")
    }
}

fun typeCastingWithNullable(obj: Any?) {
//    null 입력값시 NPE 발생
//    val person = obj as Person
//    println(person.age)
    val person = obj as? Person
    println(person?.age)
}

fun unitReturn(): Unit {
    // var list: List<Unit>;
    // return Unit
    return
}

/**
 * 코틀린에만 존재하는 특이한 타입 3가지
 *
 * Any
 * - java의 Object 역할 (모든 객체의 최상위 타입)
 * - 모든 Primitive Type의 촤싱위 타입도 Any이다.
 * - Any 자체는 null을 포함할 수 없어 null을 포함하고 싶다면 Any?로 표현해야 한다.
 *
 * Unit
 * - Unit은 Java의 void와 유사하다.
 * - void, Void 둘 다 Unit 이라고 보면 된다.
 * - 함수형 프로그래밍에서 Unit은 단 하나의 인스턴스만 갖는 타입을 의미. 코틀린의 Unit은 실제 존재하는 타입이라는 것을 표현
 *
 * Nothing
 * - 함수가 정상적으로 끝나지 않았다는 사실을 표현하는 역할
 * - 무조건 예외를 반환하거나 무한루프하는 함수 등..
 * - 쓸일이 있을까?
 */


fun stringInKotlin(person: Person) {
    // String.format을 좀 더 편하게 쓸 수 있다.
    println("사람의 이름은 ${person.name} 이고 사람의 나이는 ${person.age}이다.")

    // StringBuilder.append를 이렇게 대체할 수 있다.
    val str: String =
        """
        하나의 문장을 사용하고
        또 하나의 문장을 사용하고나면
        스트링빌더를 사용하지 않더라도
        이렇게 쓸 수 있다
        근데 나는 스트링빌더가 더 맘에드는데?
        decompile하니까 아래와 같은 코드로 변환되는 구나
        str = "하나의 문장을 사용하고\n또 하나의 문장을 사용하고나면\n스트링빌더를 사용하지 않더라도\n이렇게 쓸 수 있다\n근데 나는 스트링빌더가 더 맘에드는데?";
        """.trimIndent()
    println(str)

    // charAt 대체
    val str2 = "ABC"
    println(str2[1])
}