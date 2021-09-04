package vendingmachine.domain;

import java.util.Objects;

/**
 * 금액.
 */
public class Price {
    private static final int MINIMUM_PRICE_VALUE = 100;
    private int value;

    public Price(int value) {
        if (value < MINIMUM_PRICE_VALUE) {
            throw new IllegalArgumentException(MINIMUM_PRICE_VALUE + "보다 커야합니다");
        }
        this.value = value;
    }

    public Price addPrice(int value) {
        return new Price(this.value + value);
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Price)) return false;
        Price price = (Price) o;
        return getValue() == price.getValue();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }
}
