package vendingmachine.domain;

import java.util.Objects;

/**
 * 금액.
 */
public class Price {
    private static final int MINIMUM_PRICE_VALUE = 100;
    private static final int MINIMUM_PRICE = 10;
    private static final String PRICE_MOD_NOT_MATCH = "가격은 10원으로 나누어 떨어져야합니다.";
    private int value;

    public Price(int value) {
        validatePrice(value);
        this.value = value;
    }

    private void validatePrice(int value) {
        if (value < MINIMUM_PRICE_VALUE) {
            throw new IllegalArgumentException(MINIMUM_PRICE_VALUE + "보다 커야합니다");
        }
        if (value % MINIMUM_PRICE != 0) {
            throw new IllegalArgumentException(PRICE_MOD_NOT_MATCH);
        }
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
