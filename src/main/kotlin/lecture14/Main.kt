package lecture14

/**
 * 코틀린에서 다양한 클래스는 다루는 방법
 */
fun main() {

    val personDTO: PersonDTO = PersonDTO("test", 100)
    val personDTO2: PersonDTO = PersonDTO("test2", 200)

    // toString
    println(personDTO)
    println(personDTO2)

    // equals
    println(personDTO == personDTO2)
    println(personDTO == personDTO)

    // hashCode
    println(personDTO.hashCode())


    handlerCountry(Country.AMERICA);
    handleCar(Bmw())
    handleCar(Audi())
}

fun handlerCountry(country: Country) {
    when (country) {
        Country.KOREA -> println("korea")
        Country.AMERICA -> println("us")
    }
    // enum에 경우 compile시에 내용을 다 알고 있기 떄문에 else를 굳이 주지 않아도 괜찮다.
}

fun handleCar(car: Car) {
    when (car) {
        is Bmw -> car.clock()
        is Audi -> car.clock()
    }
}

/**
 * DTO
 */
// data 를 붙이면 Equals, hashCode, toString 등을 자동으로 붙여준다.
// named argument를 사용하는 경우 builder 까지 있다고 생각하고 쓸 수 있다.
data class PersonDTO(
    val name: String,
    val age: Int
) {

}

/**
 * Enum
 */
enum class Country(
    private val code: String
) {

    KOREA("ko"),
    AMERICA("us"),
}

/**
 * Sealed Class, Interface
 *
 * 상속이 가능하도록 추상클래스를 만들고자 할 때,
 * 외부에서는 이 클래스를 상속받지 않았으면 좋겠다는 배경에서 만들어진 클래스
 *
 *
 * 컴파일 타임때 하위 클래스의 타입을 모두 기억한다.
 * 즉 런타임때 클래스 타입이 추가될 수 없다
 * 하위 클래스는 같은 패키지에 있어야한다.
 *
 *
 * enum과 다른점
 *  - 클래스를 상속받을 수 있다
 *  - 하위 클래스의 경우 싱글톤이 아니기 때문에 여러개의 인스턴스를 가질 수 있다.
 *
 * 사용 용례
 * 추상화가 필요한 entity / DTO 가 필요한 경우 사용할 수 있다.
 */
sealed class Car(
    val name: String,
    val price: Long
) {
    abstract fun clock()
}

class Bmw() : Car("bmw", 9999L) {
    override fun clock() {
        println("자동차 사고 싶다")
    }
}
class Audi() : Car("audi", 9999L) {
    override fun clock() {
        println("티코라도 좋으니까")
    }
}
