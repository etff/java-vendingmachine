package vendingmachine.domain;

public class Item {
    private final Name name;
    private final Quantity quantity;
    private final Price price;

    public Item(String name, int quantity, int price) {
        this.name = new Name(name);
        this.quantity = new Quantity(quantity);
        this.price = new Price(price);
    }
}
