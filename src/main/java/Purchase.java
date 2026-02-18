public class Purchase {
    private String itemName;

    private double price;

    private boolean isDrink;


    public Purchase() {
        this.itemName = "";

        this.price = 0.0;

        this.isDrink = false;
    }


    public Purchase(String itemName, double price, boolean isDrink) {
        this.itemName = itemName;

        this.price = price;

        this.isDrink = isDrink;
    }


    public String getItemName() {
        return itemName;

    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0) price = 0;
        this.price = price;
    }

    public boolean isDrink() {
        return isDrink;
    }

    public void setDrink(boolean drink) {
        isDrink = drink;
    }


    public int pointsEarned() {
        return (int) (price * 10);
    }

    @Override
    public String toString() {
        return itemName + " - $" + String.format("%.2f", price);


    }
}
