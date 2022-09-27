package lecture02;

import org.jetbrains.annotations.NotNull;

public class PersonJava {

    private final String name;

    public PersonJava(String name) {
        this.name = name;
    }

    @NotNull
    public String getName() {
        return name;
    }
}
