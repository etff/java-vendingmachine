package vendingmachine.domain;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class CoinGeneratorTest {

    @Test
    void generate() {
        CoinGenerator coinGenerator = new CoinGenerator(450);

        Map<Integer, Integer> coins = coinGenerator.getCoins();
        assertThat(coins).isNotEmpty();
    }
}
