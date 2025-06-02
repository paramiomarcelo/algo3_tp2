package edu.fiuba.algo3.clases;

import java.util.ArrayList;
import java.util.List;

//Unidades
public class Unit extends Cards {

    private String section;
    private int points;
    private List<Ability> abilities;

    public Unit(String name, int points, String section, String description) {

        super(name, description);
        this.points = points;
        this.section = section;
        this.abilities = new ArrayList<>();
    }

}
