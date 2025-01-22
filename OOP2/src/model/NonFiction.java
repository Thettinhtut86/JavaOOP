package model;

public class NonFiction extends ModelBook{
    public NonFiction(int id, String title, String author, int year){
        super(id,title,author,year);
    }

    @Override
    public void displayDetails() {
        System.out.println("Non-Fiction Book - ID: " + getId() + ", Title: " + getTitle() + ", Author: " + getAuthor() + ", Year: " + getReleasedYear());
    }
}
