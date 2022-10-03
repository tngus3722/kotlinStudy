package lecture10

abstract class Animal(
    protected val species: String,
    protected open val legCount: Int // 하위 클래스에서 프로퍼티에서 override를 하기 위해서는 open 키워드가 필요하다
) {

    abstract fun move()
}