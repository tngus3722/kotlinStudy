package lecture9;

public class PersonJava9 {

    private final String name;
    private int age;

    public PersonJava9(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
}
