package lecture4

/**
 * 코틀린에서 연산자를 다루는 방법
 */
fun main() {
    moneyCompare()
    identityAndEquality()
    연산자오버로딩()
}

// 기본 산술 연산자는 자바와 완전히 동일하다.
// 비교연산자또한 자바와 완전히 동일하다.
// 하지만 객체를 비교하는 경우 compareTo를 자동으로 사용해준다.
// 객체에 compareTo가 없는 경우 에러를 발생한다. (근데 이건 자바도 마찬가지다 애초에 자바는 비교연산자를 쓸 수 없다..)
// 그렇다면 코틀린 객체끼리에 비교는 어떨까? compareTo가 필요할까? => 필요하다. 없으면 에러가 발생한다.
fun moneyCompare(): Unit {

    val moneyJava = MoneyJava(3_000L);
    val moneyJava2 = MoneyJava(2_000L);

    println(moneyJava > moneyJava2);

    val moneyKotlin = MoneyKotlin(1_000L);
    val moneyKotlin2 = MoneyKotlin(2_000L);

    println(moneyKotlin > moneyKotlin2)
}

class MoneyKotlin(amount: Long) : Comparable<MoneyKotlin> {

    val amount: Long = amount

    override fun compareTo(other: MoneyKotlin): Int {
        return this.amount.compareTo(other.amount)
    }

    operator fun plus(other: MoneyKotlin): MoneyKotlin {
        return MoneyKotlin(this.amount + other.amount);
    }

    override fun toString(): String {
        return "MoneyKotlin(amount=$amount)"
    }


}


// 동등성과 동일성
// 자바에서는 == 레퍼런스(주소값이)가 같으냐 (동일성)
// 자바에서는 .equals 사용하여 값이 같느냐 (동등성)
fun identityAndEquality() {
    val moneyJava = MoneyJava(2_000L);
    val moneyJava2 = moneyJava
    val moneyJava3 = MoneyJava(2_000L);

    // 코틀린에서는 == 으로 .equals를 호출하며 동등성 비교하며 === 으로 동일성을 비교한다.
    // 자바와는 반대이다

    println(moneyJava == moneyJava2)
    println(moneyJava === moneyJava2)
    println(moneyJava == moneyJava3)
    println(moneyJava === moneyJava3)
}

// && || ! 논리연산자는 자바와 동일하다.

// 코틀린에 있는 특이한 연산자, 반복문 강의에서 다룬다.
// in, !in
// a..b

// C++에서 가끔 보던 연산자오버로딩... 근데 이거 실제로 쓸일이 있긴있나?
fun 연산자오버로딩() {
    val moneyKotlin = MoneyKotlin(1_000L)
    val moneyKotlin2 = MoneyKotlin(2_000L)

    println(moneyKotlin + moneyKotlin2);
}