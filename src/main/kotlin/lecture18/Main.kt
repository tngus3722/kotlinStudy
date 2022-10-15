package lecture18

/**
 * 코틀린에서 컬렉션을 함수처럼 다루는 방법
 */
fun main() {
    val coffeeList: List<Coffee> = listOf(
        Coffee(1L, "레쓰비", 1000L),
        Coffee(2L, "바리스타", 1500L),
        Coffee(3L, "바리스타", 1500L),
        Coffee(4L, "스타벅스", 5000L),
        Coffee(5L, "투썸", 3000L),
        Coffee(6L, "투썸", 3500L)
    )

    coffeeList
        .filter { coffee -> coffee.name == "바리스타" }
        .forEach { coffee -> println(coffee.name) }

    println("=========================")

    coffeeList
        .filterIndexed { idx, coffee ->
            println(idx)
            coffee.name == "투썸"
        }
        .map { coffee ->
            coffee.price
        }
        .forEach { price -> println(price) }


    // all 모두 만족하면 true
    println("=========================")
    println(coffeeList.filter { coffee -> coffee.name == "스타벅스" }.all { coffee -> coffee.name == "스타벅스" })
    // none 조건을 모두 불만족하면 true
    println("=========================")
    println(coffeeList.filter { coffee -> coffee.name == "스타벅스" }.none { coffee -> coffee.name == "투썸" })
    // any 조건을 하나라도 만족하면 true
    println("=========================")
    println(coffeeList.filter { coffee -> coffee.price > 3000 }.any { coffee -> coffee.name == "레쓰비" })

    // 사이즈 구하기
    println("=========================")
    println(coffeeList.size)


    // 정순정렬
    println("=========================")
    coffeeList.sortedBy { coffee -> coffee.price }.forEach { coffee -> println(coffee) }


    // 역순정렬
    println("=========================")
    coffeeList.sortedByDescending { coffee -> coffee.price }.forEach { coffee -> println(coffee) }

    // distinct 중복 제거
    println("=========================")
    coffeeList.distinctBy { coffee -> coffee.name }.forEach { coffee -> println(coffee.name) }

    // 첫번째와 마지막 인덱스
    // first는 무조건 null이 아니어야한다 (null 인경우 exception 발생)
    // firstOrNull null을 가저올 수 있다.
    println("=========================")
    println(coffeeList.last())

    // List to Map
    println("=========================")
    val map: Map<String, List<Coffee>> = coffeeList.groupBy { coffee -> coffee.name }
    println(map)

    // associatedBy
    // 중복되지 않는 유니크한 키로 List to Map
    // if any two elements would have the same key returned by keySelector the last one gets added to the map.
    println("=========================")
    val map2: Map<Long, Coffee> = coffeeList.associateBy { coffee -> coffee.id }
    println(map2)

    println("=========================")
    val map3: Map<String, List<Long>> = coffeeList.groupBy({ coffee -> coffee.name }, { coffee -> coffee.price })
    println(map3)

    println("=========================")
    val map4: Map<Long, Long> = coffeeList.associateBy({ coffee -> coffee.id }, { coffee -> coffee.price })
    println(map4)


    // 중첩된 컬렉션 처리
    val coffeeListInList: List<List<Coffee>> = listOf<List<Coffee>>(
        listOf<Coffee>(
            Coffee(1, "레쓰비", 1000),
            Coffee(2, "레쓰비", 1200),
            Coffee(3, "레쓰비", 1200),
        ),
        listOf<Coffee>(
            Coffee(4, "스타벅스", 5000),
            Coffee(5, "스타벅스", 5300),
        ),
        listOf<Coffee>(
            Coffee(6, "투썸", 4000),
            Coffee(7, "투썸", 4500),
        ),
    )

    println("=========================")
    coffeeListInList.flatMap { list ->
        list.filter { coffee -> coffee.price > 3000 }
    }.forEach { coffee ->
        println(coffee)
    }

    println("=========================")
    coffeeListInList.flatten().forEach { coffee -> println(coffee) }

}

