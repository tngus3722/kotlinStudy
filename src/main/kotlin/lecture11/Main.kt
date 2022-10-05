package lecture11

/**
 * 코틀린에서 접근제어를 다루는 방법
 *
 * 자바랑 차이점
 * protected -> 같은 패키지 조건이 사라졌다 :: 더 나은듯
 * default -> internal (같은 모듈에서만 사용가능) :: 사실 이건 뭐... 쓸일이 있을까
 *
 * 기본 접근 지시어는 Default -> public 으로 변함
 */
fun main() {


}

/**
 * file level
 */
// public이 기본 (생략가능)
public val str: String = "string"

// top-level(file)에는 protected를 붙일 수 없음
// protected val str2: String = "String"
internal val str3: String = "string"
private val str4: String = "string"

/**
 * class level
 *
 * 동일하지만, 생성자에 대해서 조금 차이가 있다.
 * internal, private, protected를 사용할 때는 constructor를 명시적으로 작성해야한다
 * protected는 open 지시어를 붙이도록 warning이 나온다. (open을 붙이지 않으면 final Class이기 떄문)
 */

open class Cat protected constructor(
    internal val name: String, // setter만 internal
    private val owner: String, // getter, setter private
    var _price: Int // 단순 매게변수
) {

    var price = _price
        private set // setter만 private
}

/**
 * 자바와 코틀린을 같이 사용할 때 주의
 *
 * internal -> 자바 코드상 public이다.
 * -> 자바에서는 코틀린 모듈에 있는 internal을 다른 모듈이더라도 사용할 수 있다.
 * protected는 각각 다르다.
 * -> 자바에서는 kotlin protected 이더라도 하위클래스가 아니더라도 같은 패키지에서 사용할 수 있다.
 */



