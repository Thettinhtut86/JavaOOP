package model;

public interface Book {
    int getId();
    void setId(int id);

    String getTitle();
    void setTitle(String title);

    String getAuthor();
    void setAuthor(String author);

    int getReleasedYear();
    void setReleasedYear(int year);

    void displayDetails();
}
