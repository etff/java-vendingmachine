package vendingmachine.domain;

import java.util.Objects;

/**
 * 상품의 이름.
 */
public class Name {
    private static final String NAME_BLANK_NOT_ALLOW = "상품명은 공백이 되어서는 안됩니다.";
    private String value;

    public Name(String value) {
        if (value.isBlank()) {
            throw new IllegalArgumentException(NAME_BLANK_NOT_ALLOW);
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Name)) return false;
        Name name = (Name) o;
        return Objects.equals(getValue(), name.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }
}
