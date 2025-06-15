package edu.fiuba.algo3.modelo.lectorArchivo;

import edu.fiuba.algo3.modelo.effect.SpecialEffect;

import java.util.List;

public class SpecialCardFormat {
    public String name;
    public String description;
    public SpecialEffect effect;

    public SpecialCardFormat(String name, String description, SpecialEffect effect) {
        this.name = name;
        this.description = description;
        this.effect = effect;
    }
}
