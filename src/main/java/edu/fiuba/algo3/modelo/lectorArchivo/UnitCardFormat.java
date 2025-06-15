package edu.fiuba.algo3.modelo.lectorArchivo;

import edu.fiuba.algo3.modelo.ability.Ability;
import edu.fiuba.algo3.modelo.card.Point;

public class UnitCardFormat {
    public String name;
    public Point points;
    public Ability ability;
    public String section;

    public UnitCardFormat(String name, Point points, Ability ability, String section) {
        this.name = name;
        this.points = points;
        this.ability = ability;
        this.section = section;
    }



}
