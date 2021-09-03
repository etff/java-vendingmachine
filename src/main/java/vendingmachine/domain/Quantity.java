package vendingmachine.domain;

import java.util.Objects;

public class Quantity {
    private static final String MINIMUM_QUANTITY_REQUIRED = "수량은 0보다 커야합니다.";
    private final int value;

    public Quantity(int value) {
        if (value < 0) {
            throw new IllegalArgumentException(MINIMUM_QUANTITY_REQUIRED);
        }
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Quantity)) return false;
        Quantity quantity = (Quantity) o;
        return getValue() == quantity.getValue();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }
}
