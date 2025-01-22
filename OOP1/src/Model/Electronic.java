package Model;

public class Electronic extends Product{
    public int warrantyPeriod;

    public Electronic(int id, String name, double price, int quantity, int warrantyPeriod){
        super(id,name,price,quantity);
        this.warrantyPeriod = warrantyPeriod;
    }

    public int getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public void setWarrantyPeriod(int warrantyPeriod) {
        this.warrantyPeriod = warrantyPeriod;
    }

    @Override
    public void displayDetails() {
        System.out.println("Electronics: " + toString() + ", Warranty Period: " + warrantyPeriod + " months");
    }
}
