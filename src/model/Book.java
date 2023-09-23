
package model;

/**
 *
 * @author Andres
 */
public class Book {
    
    private String title;
    private  String codeISBN;
    private  int  tomo;
    private String editorial;
    private Author autor;
    private int numberBooks;

    public Book(String title, String codeISBN, int tomo, String editorial, Author autor) {
        this.title = title;
        this.codeISBN = codeISBN;
        this.tomo = tomo;
        this.editorial = editorial;
        this.autor = autor;
    }

    public Author getAutor() {
        return autor;
    }

    public String getCodeISBN() {
        return codeISBN;
    }

    public String getEditorial() {
        return editorial;
    }

    public String getTitle() {
        return title;
    }

    public int getTomo() {
        return tomo;
    }

    public void setAutor(Author autor) {
        this.autor = autor;
    }

    public void setCodeISBN(String codeISBN) {
        this.codeISBN = codeISBN;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public void setNumberBooks(int numberBooks) {
        this.numberBooks = numberBooks;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTomo(int tomo) {
        this.tomo = tomo;
    }
    
    
    
    
    
}
