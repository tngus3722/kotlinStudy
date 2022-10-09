package lecture15

/**
 * 코틀린에서 배열과 컬렉션을 다루는 방법
 */
fun main() {

    // 배열
    val array = arrayOf(100, 200)
    for (i in 0..array.size - 1) {
        println("index : ${i}, value ${array[i]}")
    }

    for (i in array.indices) {
        println("index : ${i}, value ${array[i]}")
    }

    for ((idx, value) in array.withIndex()) {
        println("index : ${idx}, value ${value}")
    }

    array.plus(300)

    /**
     * 콜렉션
     *
     * 가변(mutable) 콜렉션 : 컬렉션에 엘리먼트를 추가 삭제할 수 있다.
     * 불변 콜렉션 : 컬렉션에 엘리먼트를 추가, 삭제할 수 없다.
     * 불편 콜렉션이더라도 새로운 원소를 넣거나 뺄 수는 없지만. 이미 들어있는 레퍼런스 타입의 값은 바꿀 수 있다.
     * 코틀린은 기본적으로 불변 콜렉션을 사용한다.
     *
     * 보통 불변으로 만들고 필요한 경우 가변으로 바꾼다.
     */
    val numbers = listOf<Int>(10, 20)
    val emptyList = emptyList<Int>()
    printIterator(numbers)

    val numbersMutable = mutableListOf(10, 20)
    numbersMutable.add(30)
    printIterator(numbersMutable)

    val numberSet = setOf(10, 10, 30, 20)
    printIterator(numberSet)


    val numberSetMutable = mutableSetOf(10, 10, 30, 20)
    numberSetMutable.add(10)
    numberSetMutable.add(40)
    printIterator(numberSetMutable)

    val oldMap = mutableMapOf<Int, String>()
    oldMap[1] = "One" // put(1, "One") 으로 사용할 수 있다
    oldMap[2] = "Two"
    printMap(oldMap)
    val map = mapOf<Int, String>(1 to "One", 2 to "Two")
    printMap(map)

    /**
     * List<Int?> 리스트에 null이 들어갈 수 있지만 List 자체는 null일 수 있다.
     * List<Int>? 리스트에는 null이 들어갈 수 없지만 List 자체는 Null일 수 있다.
     * List<Int?>? 둘 다 null이 가능하다
     */

    /**
     * java와 함께 사용할 떄 주의할 점
     *
     * 자바는 불변, 가변 리스트를 구별하지 않는다.
     * 자바는 non-nullable, nullable을 구분 하지 않는다.
     *
     * 자바에서 콜렉션을 받아와서 사용할 땐 자바에서 non-nullable 리스트에 null을 넣을 수도 있고. 불변 컬렉션을 수정할 수 도 있다.
     * 코틀린에서 자바를 받아올 때는 플랫폼 타입을 신경써야한다. -> 래퍼 클래스를 적절히 만들어서 영양 범위를 최소화 하는 것이 좋다.
     */
}

private fun printIterator(numbers: Iterable<Int>) {
    println("---printIterator---")
    println(numbers.javaClass)
    for ((idx, value) in numbers.withIndex()) {
        println("index : ${idx}, value ${value}")
    }
}

private fun printMap(map: Map<Int, String>) {
    println("---printMap---")
    for (key in map.keys) {
        println(key)
    }

    for((key, value) in map.entries) {
        println("key : ${key}, value : ${value}")
    }
}