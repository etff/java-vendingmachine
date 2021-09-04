package vendingmachine.domain;

/**
 * 상품의 아이템.
 */
public class Item {
    private Name name;
    private Quantity quantity;
    private Price price;

    public Item(String name, int quantity, int price) {
        this.name = new Name(name);
        this.quantity = new Quantity(quantity);
        this.price = new Price(price);
    }

    public Item(Name name, Quantity quantity, Price price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public Name getName() {
        return name;
    }

    public Quantity getQuantity() {
        return quantity;
    }

    public Price getPrice() {
        return price;
    }

    public Item purchase() {
        this.quantity = this.quantity.subtract(1);
        return this;
    }
}
