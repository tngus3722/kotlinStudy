package lecture17

/**
 * 코틀린에서 람다를 다루는 방법
 *
 * 코틀린에서는 함수가 1급 객체이다.
 */
fun main() {

    val fruits: List<Fruit> = listOf(
        Fruit("사과", 3000L),
        Fruit("사과", 3100L),
        Fruit("사과", 3200L),
        Fruit("사과", 3300L),
        Fruit("바나나", 1000L),
        Fruit("바나나", 1300L),
        Fruit("포도", 1500L)
    )

    // 람다를 만드는 방법 1
    val isApple: (Fruit) -> Boolean = fun(fruit: Fruit): Boolean {
        return fruit.name == "사과"
    }
    // 람다를 만드는 방법 2
    val isApple2: (Fruit) -> Boolean = { fruit: Fruit -> fruit.name == "사과" }
    // 람다를 호출하는 방법 1
    println(isApple(fruits[0]))
    // 람다를 호출하는 방법 2
    println(isApple2.invoke(fruits[1]))


    // 아래 모두 같음
    fruitFilter(fruits, isApple)
    fruitFilter(fruits) { fruit: Fruit -> fruit.name == "사과" }
    fruitFilter(fruits) { o -> o.name == "사과" }
    fruitFilter(fruits) { it.name == "사과" }
    fruitFilter2(fruits) { it.name == "사과" }
    val apple: String = "사과"
    // 코틀린은 closure 개념이 들어있어 람다 밖에서 선언된 변수에 대한 정보를 모두 가지고 있다.
    fruitFilter2(fruits) { it.name == apple }
}

private fun fruitFilter(fruits: List<Fruit>, filter: (Fruit) -> Boolean): List<Fruit> {
    val results: MutableList<Fruit> = mutableListOf<Fruit>()
    for (fruit: Fruit in fruits) {
        if (filter(fruit)) {
            results.add(fruit)
        }
    }

    return results
}

private fun fruitFilter2(fruits: List<Fruit>, filter: (Fruit) -> Boolean): List<Fruit> {
    return fruits.filter(filter)
}