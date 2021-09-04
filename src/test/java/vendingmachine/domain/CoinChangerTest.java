package vendingmachine.domain;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class CoinChangerTest {

    @Test
    void remain() {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(50, 1);
        map.put(100, 4);

        int remains = 500;

        CoinChanger coinChanger = new CoinChanger(map, remains);

        CoinResult coinResult = coinChanger.getResult();
        assertThat(coinResult.getChanges()).isNotEmpty();
        assertThat(coinResult.getRemains()).isEqualTo(50);
    }
}
