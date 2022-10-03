package lecture10

interface Flyable {

    // 코틀린에서는 Default 키워드가 따로 없이 default 함수를 만들 수 있다.
    fun act() {
        println("파닥파닥")
    }

    fun fly()
}