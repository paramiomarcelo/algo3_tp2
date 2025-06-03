package edu.fiuba.algo3.clases;

public class Specials extends Cards {

    Ability ability;
    public Specials(String name, String description, Ability ability) {

        super(name, description, true);
        this.ability = ability;

    }
    public void play(Board board, Player player) {
        ability.effect(board);
    }

}
