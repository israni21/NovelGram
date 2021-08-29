package com.androidcoding.novelgram;

public class BookName {

    //Initialise
    private final String author_name;
    private final String book_name;
    private String id;
    private int image;

    public BookName(String id, String book_name2, String author_name2, int image2) {
        this.id = id;
        this.book_name = book_name2;
        this.author_name = author_name2;
        this.image = image2;
    }

    //Getter and Setter Methods
    public int getImage() {
        return this.image;
    }

    public void setImage(int image2) {
        this.image = image2;
    }

    public String getBook_name() {
        return this.book_name;
    }


    public String getAuthor_name() {
        return this.author_name;
    }


    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
