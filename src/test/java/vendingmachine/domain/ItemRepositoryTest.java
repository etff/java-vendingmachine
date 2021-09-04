package vendingmachine.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ItemRepositoryTest {
    private Name targetName;
    private ItemRepository itemRepository;

    @BeforeEach
    void setUp() {
        itemRepository = new ItemRepository();
        targetName = new Name("콜라");
    }

    @Test
    void add() {
        final Item item = new Item("콜라", 20, 100);

        itemRepository.addItem(item);

        assertThat(itemRepository.getItem(targetName)).isNotNull();
    }

    @Test
    void subtract() {
        final Item item = new Item("콜라", 20, 100);
        itemRepository.addItem(item);

        itemRepository.subtractItem(targetName);

        Item findItem = itemRepository.getItem(targetName)
                .orElseThrow(IllegalArgumentException::new);
        assertThat(findItem.getQuantity()).isEqualTo(new Quantity(19));
    }

    @Test
    void findItemsSoldOut() {
        final Item item1 = new Item("콜라", 0, 100);
        final Item item2 = new Item("사이다", 0, 100);
        itemRepository.addItem(item1);
        itemRepository.addItem(item2);

        assertThat(itemRepository.findItemsSoldOut()).isTrue();
    }

    @Test
    void findMinimumPrice() {
        final Item item1 = new Item("콜라", 0, 1000);
        final Item item2 = new Item("사이다", 0, 500);
        itemRepository.addItem(item1);
        itemRepository.addItem(item2);

        int actual = itemRepository.findMinimumPrice();

        assertThat(actual).isEqualTo(500);
    }
}
