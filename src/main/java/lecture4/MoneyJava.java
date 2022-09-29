package lecture4;

import java.util.Objects;
import org.jetbrains.annotations.NotNull;

public class MoneyJava implements Comparable<MoneyJava> {

    private Long amount;

    public MoneyJava(Long amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MoneyJava moneyJava = (MoneyJava) o;
        return Objects.equals(amount, moneyJava.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }

    @Override
    public int compareTo(@NotNull MoneyJava o) {
        return Long.compare(this.amount, o.amount);
    }
}
