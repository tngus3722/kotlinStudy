package lecture17;

public class Fruit {

    private String name;
    private Long price;

    public Fruit(String name, Long price) {
        this.name = name;
        this.price = price;
    }

    public Long getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}
