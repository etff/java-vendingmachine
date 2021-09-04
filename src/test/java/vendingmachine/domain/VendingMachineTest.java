package vendingmachine.domain;

import org.junit.jupiter.api.Test;
import vendingmachine.application.VendingMachine;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class VendingMachineTest {

    @Test
    void addItem() {
        VendingMachine vendingMachine = new VendingMachine(450);
        Item item1 = new Item("콜라", 20, 100);
        Item item2 = new Item("사이다", 10, 1000);

        vendingMachine.addItems(List.of(item1, item2));

        assertThat(vendingMachine.getItems()).hasSize(2);
    }

    @Test
    void insertMoney() {
        VendingMachine vendingMachine = new VendingMachine(450);

        vendingMachine.insertMoney(3000);

        assertThat(vendingMachine.getRemainUserMoney()).isEqualTo(3000);
    }

    @Test
    void purchaseItem() {
        VendingMachine vendingMachine = new VendingMachine(450);
        vendingMachine.insertMoney(3000);
        Item item1 = new Item("콜라", 20, 1500);
        Item item2 = new Item("사이다", 10, 1000);
        vendingMachine.addItems(List.of(item1, item2));

        vendingMachine.purchase("콜라");

        Item actual = vendingMachine.getItem("콜라");
        assertThat(vendingMachine.getRemainUserMoney()).isEqualTo(1500);
        assertThat(actual.getQuantity().getValue()).isEqualTo(19);
    }

    @Test
    void coinResult() {
        VendingMachine vendingMachine = new VendingMachine(450);
        vendingMachine.insertMoney(500);
        Item item1 = new Item("콜라", 20, 1500);
        Item item2 = new Item("사이다", 10, 1000);
        vendingMachine.addItems(List.of(item1, item2));

        CoinResult result = vendingMachine.purchase("콜라");

        assertThat(result.getRemains()).isEqualTo(50);
    }
}
