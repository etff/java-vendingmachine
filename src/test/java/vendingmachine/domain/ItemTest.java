package vendingmachine.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ItemTest {

    @Test
    void create() {
        Item item = new Item("콜라", 20, 100);

        assertThat(item).isNotNull();
    }

    @ParameterizedTest
    @CsvSource(value = {"' ', 5, 100", "'콜라', -5, 100", "콜라, 5, 50"})
    void parameter_validation(String name, int quantity, int price) {
        assertThatThrownBy(() -> {
            new Item(name, quantity, price);
        }).isInstanceOf(IllegalArgumentException.class);
    }

}
