package lecture10


// 코틀린에서는 상속을 받을 때 상위 클래스에 생성자를 꼭 호출해주어야 한다
class Cat(
    species: String
) : Animal(species, 4) {

    override fun move() {
        println("고양이가 움직인다")
    }

}