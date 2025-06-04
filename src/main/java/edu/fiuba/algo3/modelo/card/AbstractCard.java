package edu.fiuba.algo3.modelo.card;

public abstract class AbstractCard implements Card {
    protected String name;
    protected String description;

    public AbstractCard(String name, String description) {
        this.name = name;
        this.description = description;
    }
    public String getName() { return name;}

}
