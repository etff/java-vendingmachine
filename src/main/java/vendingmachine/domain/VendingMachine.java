package vendingmachine.domain;

import java.util.List;
import java.util.Map;

/**
 * 자판기.
 */
public class VendingMachine {
    /**
     * 현재 자판기의 잔돈.
     */
    private Map<Integer, Integer> coins;
    /**
     * 남은 금액.
     */
    private int remainUserMoney;
    /**
     * 자판기의 아이템.
     */
    private ItemRepository itemRepository;

    public VendingMachine(int remainAmount) {
        this.itemRepository = new ItemRepository();
        this.remainUserMoney = 0;
        this.coins = new CoinGenerator(remainAmount).getCoins();
    }

    public void addItems(List<Item> items) {
        for (Item item : items) {
            itemRepository.addItem(item);
        }
    }

    public Item getItem(String name) {
        return itemRepository.getItem(new Name(name))
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 상품입니다."));
    }

    public CoinResult purchase(String name) {
        Item item = getItem(name);
        Price price = item.getPrice();
        if (!price.canBuy(this.remainUserMoney)) {
            CoinChanger coinChanger = new CoinChanger(this.coins, this.remainUserMoney);
            return coinChanger.getResult();
        }
        subtractItem(name, price);
        return new CoinResult();
    }

    public List<Item> getItems() {
        return itemRepository.getItems();
    }

    public void insertMoney(int value) {
        this.remainUserMoney += value;
    }

    public int getRemainUserMoney() {
        return remainUserMoney;
    }

    private void subtractItem(String name, Price price) {
        itemRepository.subtractItem(new Name(name));
        this.remainUserMoney -= price.getValue();
    }
}
