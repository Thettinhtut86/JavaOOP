package model;

public class Fiction extends ModelBook{
    public Fiction(int id,String title, String author, int year){
        super(id,title,author,year);
    }
    @Override
    public void displayDetails() {
        System.out.println("Fiction Book - ID: " + getId() + ", Title: " + getTitle() + ", Author: " + getAuthor() + ", Year: " + getReleasedYear());
    }
}
