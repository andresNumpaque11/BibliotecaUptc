package model;

/**
 *
 * @author Andres
 */
public class Author {
    private String name;
    private String lastName;
    private String biography;

    public Author(String name, String lastName, String biography) {
        this.name = name;
        this.lastName = lastName;
        this.biography = biography;
    }

    public String getBiography() {
        return biography;
    }

    public String getLastName() {
        return lastName;
    }

    public String getName() {
        return name;
    }
    
    
    
    
    
}
