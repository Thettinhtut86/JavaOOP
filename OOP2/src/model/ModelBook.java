package model;

public abstract  class ModelBook implements Book{
    private int id;
    private String title;
    private String author;
    private int releasedYear;

    public ModelBook(int id,String title, String author, int releasedYear) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.releasedYear = releasedYear;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getAuthor() {
        return author;
    }

    @Override
    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public int getReleasedYear() {
        return releasedYear;
    }

    @Override
    public void setReleasedYear(int releasedYear) {
        this.releasedYear = releasedYear;
    }

    @Override
    public void displayDetails() {
        System.out.println("Id :"+id+"Title: " + title + ", Author: " + author + ", Year: " +releasedYear);
    }

    @Override
    public String toString() {
        return "ModelBook{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", releasedYear=" + releasedYear +
                '}';
    }
}
