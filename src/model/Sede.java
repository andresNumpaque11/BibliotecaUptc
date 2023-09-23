package model;

import java.util.ArrayList;

/**
 *
 * @author Andres
 */
public class Sede {
    
    private String ubication;
    private ArrayList<String> campusList;

    public Sede(String ubication, ArrayList<String> campusList) {
        this.ubication = ubication;
        this.campusList = campusList;
    }

    public ArrayList<String> getCampusList() {
        return campusList;
    }

    public String getUbication() {
        return ubication;
    }
    
    
    
    
    
    
    
    
    
    
}
