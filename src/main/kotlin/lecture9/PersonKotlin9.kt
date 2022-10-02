package lecture9

class PersonKotlin9(name: String, age: Int) {

    val name: String = name
    var age: Int = age

    init {
        if (age <= 0) {
            throw IllegalArgumentException("나이는 0보다 커야합니다")
        }
    }

    fun getNameUpperCase(): String {
        return this.name.uppercase()
    }

    companion object {
        fun fromPersonJava9(personJava: PersonJava9): PersonKotlin9 {
            return PersonKotlin9(personJava.name, personJava.age)
        }

        fun printClassInfo() {
            println("personKotlin class")
        }
    }

    // backing field, custom getter, setter, 부생성자등에 키워드도 있었으나 자주 사용될만한 놈들이 아님.
}