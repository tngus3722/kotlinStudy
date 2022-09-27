package lecture2

import lecture02.PersonJava

/**
 * 코틀린에서 null을 다루는 방법
 */
fun main() {
    val personJava: PersonJava = PersonJava("정수현")
    platformTypeStartWithA(personJava.name)
}

/**
 * null이 들어갈 수 있는 매개변수, null이 반환되지 않는 반환
 */
fun startWithA1(str: String?): Boolean {
    if (str == null) {
        throw IllegalArgumentException("null이 들어왔습니다.")
    }

    return str.startsWith("A")
}

/**
 * null이 들어갈 수 있는 매개변수, null이 반환가능한 반환
 */
fun startWithA2(str: String?): Boolean? {
    if (str == null) {
        return null
    }

    return str.startsWith("A")
}

/**
 * null이 들어갈 수 있는 매개변수, null이 반환 불가능한 반환
 * null 체크를 안하고 str.startsWith("A") 사용시 에러가 난다. null체크를 했는지 안했는지를 어느정도 검사해준다.
 * Nullable한 타입은 그렇지 않은 타입과 아에 다른 타입으로 간주한다
 */
fun startWithA3(str: String?): Boolean {
    if (str == null) {
        return false
    }

    return str.startsWith("A")
}

/**
 * null이 전부 허용되지 않는 함수
 */
fun startWithA4(str: String): Boolean {
    return str.startsWith("A")
}

/**
 * safeCall
 * null 이면 실행하지 않고
 * null 이 아니면 실행하지 않는다 (그대로 null이 반환된다)
 */
fun safeCallStartWithA(str: String?): Boolean? {
    return str?.startsWith("A")
}


/**
 * elvis 연산
 * safeCall과 같이 사용되며 앞의 값이 null인 경우 뒤에 값을 사용한다.
 */
fun elvisStartWithA(str: String?): Boolean {
    return str?.startsWith("A") ?: false
}

/**
 * Elvis early return
 */

fun elvisEarlyReturnStartWithA(str: String?): Boolean {
    str ?: return false;

    return str.startsWith("A");
}

/**
 * null 아님 단언 (!!)
 * 만약에 null이 들어간 경우 NPE가 발생한다.
 * 정말 null이 들어갈 수 없는 확실한 경우에만 사용한다.
 */

fun notNullStartWithA(str: String?): Boolean {
    return str!!.startsWith("A");
}

/**
 * 플랫폼 타입 (java와 같이 쓰는 경우)
 * 어노테이션이 없으면 코틀린은 null이 들어갈 수 있는지, 아닌지 알 수 없다.
 * @NotNull, @Nullable 어노테이션을 이용하여 컴파일될 수 있도록한다.
 *
 * 이 경우 RunTime에서 Exception이 발생할 수 있다.
 */
fun platformTypeStartWithA(str: String): Boolean {
    return str?.startsWith("A")
}

