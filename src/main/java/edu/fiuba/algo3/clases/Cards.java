package edu.fiuba.algo3.clases;


public abstract class Cards {

    private String name;
    private String description;
    boolean cardSpecial;

    protected Cards(String name, String description, boolean cardSpecial) {
        this.name = name;
        this.description = description;
        this.cardSpecial = cardSpecial;
    }
    public String getName() {
        return this.name;
    }
    public boolean isCardSpecial() {
        return this.cardSpecial;
    }
    public abstract void play(Board board, Player player);
}