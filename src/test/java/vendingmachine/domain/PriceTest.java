package vendingmachine.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PriceTest {

    @DisplayName("금액이 100이상 주어지면 객체가 생성됩니다.")
    @Test
    void create() {
        Price price = new Price(100);

        assertThat(price).isNotNull();
    }

    @DisplayName("금액이 100보다 작으면 예외를 던집니다.")
    @Test
    void create_with_under_100() {
        assertThatThrownBy(() -> {
            new Price(90);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("금액이 10으로 나눠지지 않으면 예외를 던집니다.")
    @ParameterizedTest
    @ValueSource(ints = {101, 103, 205, 309})
    void create_with_not_mod_10(int value) {
        assertThatThrownBy(() -> {
            new Price(value);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
