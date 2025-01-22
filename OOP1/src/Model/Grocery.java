package Model;

public class Grocery extends Product{
    public String expirationDate;

    public Grocery(int id, String name, double price, int quantity, String expirationDate) {
        super(id,name, price, quantity);
        this.expirationDate = expirationDate;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public void displayDetails() {
        System.out.println("Grocery: " + toString() + ", Expiration Date: " + expirationDate);
    }

}
