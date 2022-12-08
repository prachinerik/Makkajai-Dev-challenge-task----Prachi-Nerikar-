public class InputItem {

    int quantity;
    String name;
    float price;

    public InputItem() {
    }

    public InputItem(int quantity, String name, float price) {
        this.quantity = quantity;
        this.name = name;
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
